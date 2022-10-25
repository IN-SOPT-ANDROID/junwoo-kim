package org.sopt.sample.presentation.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.sample.presentation.model.UserData

class HomeViewModel :ViewModel() {
    private val _userData = MutableLiveData<UserData>()
    val userData get() = _userData

    fun setUserData(userData: UserData){
        _userData.value = userData
    }

}