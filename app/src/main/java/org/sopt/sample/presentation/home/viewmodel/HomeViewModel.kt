package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.data.model.repository.ReqresRepository
import org.sopt.sample.presentation.model.UserData

class HomeViewModel(private val reqresRepository: ReqresRepository) : ViewModel() {

    init {
        getReqresList()
    }

    private val _userData = MutableLiveData<UserData>()
    val userData get() = _userData

    fun setUserData(userData: UserData) {
        _userData.value = userData
    }


//    private var _reqresList = listOf<ResponseReqresListDTO.Data>()
//    val reqresList get() = _reqresList

    private val _reqresList = MutableLiveData<List<ResponseReqresListDTO.Data?>?>()
    val reqresList: LiveData<List<ResponseReqresListDTO.Data?>?> get() = _reqresList

    private fun getReqresList() = viewModelScope.launch {
        val response = reqresRepository.getList()
        if (response.isSuccessful) {
            _reqresList.value = response.body()?.data
        }
    }


}