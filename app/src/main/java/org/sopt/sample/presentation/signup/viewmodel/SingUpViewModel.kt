package org.sopt.sample.presentation.signup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingUpViewModel : ViewModel() {
    private val _activationId = MutableLiveData<Boolean>(false)
    val activationId get() = _activationId
    private var _activationPw = MutableLiveData<Boolean>(false)
    val activationPw get() = _activationPw

    fun onIDTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationId.value = s.length in 6..10
    }

    fun onPwTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        _activationPw.value = s.length in 8..12
    }


}