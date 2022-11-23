package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.domain.repository.ReqresRepository
import org.sopt.sample.presentation.model.UserData

class HomeViewModel(private val reqresRepository: ReqresRepository) : ViewModel() {

    init {
        connectReqres()
    }

    private val _userData = MutableLiveData<UserData>()
    val userData get() = _userData

    private val _success = MutableLiveData<Boolean>(true)
    val success get():LiveData<Boolean> = _success

    private val _reqresList = MutableLiveData<List<ResponseReqresListDTO.Data?>?>()
    val reqresList: LiveData<List<ResponseReqresListDTO.Data?>?> get() = _reqresList

    fun connectReqres() = viewModelScope.launch {
        val response = reqresRepository.getList(1)
        if (response.isSuccessful) {
            _reqresList.value = response.body()?.data
        }else if(response.code() in  400..500){
            _success.value = false
        }else{
            _success.value = false
        }
    }


}