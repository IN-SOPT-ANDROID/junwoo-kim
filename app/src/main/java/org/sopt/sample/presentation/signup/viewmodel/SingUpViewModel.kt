package org.sopt.sample.presentation.signup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingUpViewModel : ViewModel() {
    private val _activationId = MutableLiveData<Boolean>(false)
    val activationId get() = _activationId
    private var _activationPw = MutableLiveData<Boolean>(false)
    val activationPw get() = _activationPw




}