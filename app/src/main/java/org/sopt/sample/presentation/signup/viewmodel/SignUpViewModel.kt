package org.sopt.sample.presentation.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import org.sopt.sample.domain.repository.AuthRepository
import timber.log.Timber
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() { //TODO 변수를 추후에 리스트 형태로 관리해도 좋을듯 함

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

    //server connect
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> get() = _success


    fun onIDTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationId.value = idPattern.matcher(s).find()
        _userId.value = s.toString()
    }

    fun onPwTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationPw.value = pwPattern.matcher(s).find()
        _userPw.value = s.toString()
    }

    fun onNameTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationName.value = s.isNotEmpty()
        _userName.value = s.toString()
    }

    fun onPostSingUp() {
        viewModelScope.launch {
            kotlin.runCatching {
                authRepository.postSignUp(
                    RequestSingUpDTO(
                        userId.value ?: "", userPw.value ?: "", userName.value ?: ""
                    )
                )
            }.onSuccess {
                _success.value = it.isSuccessful
            }.onFailure {
                Timber.e(it)
            }
        }
    }

    companion object {
        // 영어,숫자 포함 6~10 글자
        val idPattern: Pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,10}$")

        // 영어,숫자,특수문자 포함 6~12 글자
        val pwPattern: Pattern =
            Pattern.compile("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{6,12}$")
    }

}