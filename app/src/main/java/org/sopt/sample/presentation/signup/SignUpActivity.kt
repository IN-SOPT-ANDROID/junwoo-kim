package org.sopt.sample.presentation.signup

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import org.sopt.sample.R
import org.sopt.sample.data.repository.AuthRepositoryImpl
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.signup.viewmodel.SignUpViewModel
import org.sopt.sample.presentation.util.AuthViewModelFactory
import org.sopt.sample.presentation.util.makeSnackbar

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {


    private lateinit var signUpViewModel: SignUpViewModel
    private val authRepository = AuthRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        val factory = AuthViewModelFactory(authRepository)
        signUpViewModel = ViewModelProvider(this, factory)[SignUpViewModel::class.java]
        binding.viewmodel = signUpViewModel
        addObserve()
    }

    private fun addObserve() {
        // 경고문구에 따라서 경고창 visible 및 edittext tint 변경
        signUpViewModel.userId.observe(this) {
            with(binding) {
                checkCondition(
                    tvWarnId,
                    etId,
                    viewmodel!!.activationId.value,
                    viewmodel!!.userId.value
                )
            }
        }

        signUpViewModel.userPw.observe(this) {
            with(binding) {
                checkCondition(
                    tvWarnPw,
                    etPw,
                    viewmodel!!.activationPw.value,
                    viewmodel!!.userPw.value
                )
            }
        }

        signUpViewModel.success.observe(this) {//button 이 enabled되고 그 이후 click되면 finish
            if (it) finish()
            else binding.root.makeSnackbar("서버통신실패!")
        }
    }

    private fun checkCondition(
        warnText: TextView,
        editText: EditText,
        activation: Boolean?,
        input: String?
    ) {
        if (!(input.isNullOrEmpty())) {
            // 경고문자 활성화 함수, 패턴만족 및 글자수 까지 검사하여 패턴만족 + 글자 있음 일때만 경고창 출력
            if (activation == true) {
                warnText.visibility = View.GONE
                editText.background.setTint(this.getColor(R.color.gray))
            } else {
                warnText.visibility = View.VISIBLE
                editText.background.setTint(this.getColor(R.color.red))
            }
        } else {
            warnText.visibility = View.GONE
            editText.background.setTint(this.getColor(R.color.gray))
        }
    }

}