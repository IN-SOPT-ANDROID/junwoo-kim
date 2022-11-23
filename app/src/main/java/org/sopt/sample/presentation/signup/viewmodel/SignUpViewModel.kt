package org.sopt.sample.presentation.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.application.ApiFactory
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import java.util.regex.Pattern

class SignUpViewModel : ViewModel() { //TODO 변수를 추후에 리스트 형태로 관리해도 좋을듯 함

    //activation
    private val _activationId = MutableLiveData<Boolean>(false)
    val activationId: LiveData<Boolean> get() = _activationId
    private val _activationPw = MutableLiveData<Boolean>(false)
    val activationPw: LiveData<Boolean> get() = _activationPw
    private val _activationName = MutableLiveData<Boolean>(false)
    val activationName: LiveData<Boolean> get() = _activationName

    //text
    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String> get() = _userId
    private val _userPw = MutableLiveData<String>()
    val userPw: LiveData<String> get() = _userPw
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    //click
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> get() = _success


    fun onIDTextChanged(s: CharSequence, start: Int, before: Int, count: Int) { // 영어,숫자 포함 6~10 글자
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$")
        _activationId.value = pattern.matcher(s).find()
        _userId.value = s.toString()
    }

    fun onPwTextChanged(s: CharSequence, start: Int, before: Int, count: Int) { // 영어,숫자,특수문자 포함 6~12 글자
        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{6,12}$")
        _activationPw.value = pattern.matcher(s).find()
        _userPw.value = s.toString()
    }

    fun onNameTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationName.value = s.isNotEmpty()
        _userName.value = s.toString()
    }

    fun onPostSingUp() {
        viewModelScope.launch {
            val response = ApiFactory.loginService.signup(
                RequestSingUpDTO(
                    userId.value!!, userPw.value!!, userName.value!!
                )
            )
            _success.value = response.isSuccessful
        }
    }

}