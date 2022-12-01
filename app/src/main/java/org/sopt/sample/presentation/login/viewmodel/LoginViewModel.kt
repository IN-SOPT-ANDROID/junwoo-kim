package org.sopt.sample.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.domain.repository.AuthRepository
import retrofit2.Response
import timber.log.Timber

class LoginViewModel(private val authRepository: AuthRepository) :ViewModel() {
    //server connect
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> get() = _success

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    //text
    private val _userId = MutableLiveData<String>()
    val userId: LiveData<String> get() = _userId
    private val _userPw = MutableLiveData<String>()
    val userPw: LiveData<String> get() = _userPw

    fun onIDTextChanged(s: CharSequence, start: Int, before: Int, count: Int) { // 영어,숫자 포함 6~10 글자
//        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$")
//        _activationId.value = pattern.matcher(s).find()
        _userId.value = s.toString()
    }

    fun onPwTextChanged(
        s: CharSequence, start: Int, before: Int, count: Int) {
        // 영어,숫자,특수문자 포함 6~12 글자
//        val pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{6,12}$")
//        _activationPw.value = pattern.matcher(s).find()
        _userPw.value = s.toString()
    }

    fun onPostLogin() {
        viewModelScope.launch {
           kotlin.runCatching {
                authRepository.postLogin(
                    RequestLoginDTO(
                        userId.value ?: "", userPw.value ?: ""
                    )
                )
            }.onSuccess {  value: Response<ResponseLoginDTO> ->
                _success.value = value.isSuccessful
            }.onFailure {
                Timber.e(it)
                _error.value = true
            }
        }
    }

}