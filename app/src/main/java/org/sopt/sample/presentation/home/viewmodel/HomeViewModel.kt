package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.sopt.sample.application.ApiFactory
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.presentation.model.UserData

class HomeViewModel :ViewModel() {
    private val _userData = MutableLiveData<UserData>()
    val userData get() = _userData

    fun setUserData(userData: UserData){
        _userData.value = userData
    }

//    private val _reqresList = MutableLiveData<List<ResponseReqresListDTO.Data?>?>()
//    val reqresList:LiveData<List<ResponseReqresListDTO.Data?>?> get() = _reqresList

    private var _reqresList = listOf<ResponseReqresListDTO.Data>()
    val reqresList get() = _reqresList

    fun getReqresList() = viewModelScope.launch(Dispatchers.IO) {
        val response = ApiFactory.reqresService.getList()
        if(response.isSuccessful){
            response.body()?.let { body->
                _reqresList = body.data as List<ResponseReqresListDTO.Data>
            }
        }
    }



}