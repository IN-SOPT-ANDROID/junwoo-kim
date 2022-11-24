package org.sopt.sample.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.domain.repository.AuthRepository
import org.sopt.sample.presentation.login.viewmodel.LoginViewModel
import org.sopt.sample.presentation.signup.viewmodel.SignUpViewModel

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    private val authRepository: AuthRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignUpViewModel::class.java)){
            return SignUpViewModel(authRepository) as T
        }else if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(authRepository) as T
        }
        else throw IllegalArgumentException("ViewModel class not found")
    }
}
