package org.sopt.sample.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.domain.repository.AuthRepository
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) :ViewModel() {
    //server connect
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> get() = _success

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> get() = _error

    //text
    private val _userId = MutableLiveData<String>()
    val userId get() = _userId
    private val _userPw = MutableLiveData<String>()
    val userPw get() = _userPw

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