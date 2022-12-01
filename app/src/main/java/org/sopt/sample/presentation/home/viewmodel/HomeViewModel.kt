package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.domain.repository.ReqresRepository
import org.sopt.sample.presentation.model.UserData
import timber.log.Timber

class HomeViewModel(private val reqresRepository: ReqresRepository) : ViewModel() {

    init {
        connectReqres()
    }

    private val _userData = MutableLiveData<UserData>()
    val userData get() = _userData

    private val _success = MutableLiveData<Boolean>() // 서버통신 성공 실패여부 판단
    val success get():LiveData<Boolean> = _success

    private val _empty = MutableLiveData<Boolean>(false) // 서버통신은 성공했으나 빈데이터인지 아닌지 판단
    val empty get():LiveData<Boolean> = _empty

    private val _reqresList = MutableLiveData<List<ResponseReqresListDTO.Data>>()
    val reqresList: LiveData<List<ResponseReqresListDTO.Data>> get() = _reqresList

    fun connectReqres() = viewModelScope.launch {
        kotlin.runCatching {
            reqresRepository.getList(2)
        }.onSuccess {
            if (it.isSuccessful && it.body() != null) { // null 체크
                with(it.body()!!.data as List<ResponseReqresListDTO.Data>) {
                    if (this.isEmpty()) {
                        _empty.value = true
                    } else {
                        _reqresList.value = this
                    }
                }
            } else { // 응답코드 400~599
                _success.value = false
            }
        }.onFailure { // 서버통신 실패 http exception 등...
            Timber.e(it)
            _success.value = false
        }
    }


}