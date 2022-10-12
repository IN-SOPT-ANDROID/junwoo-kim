package org.sopt.sample.presentation.signup

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.login.LoginActivity
import org.sopt.sample.presentation.model.UserData

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
        binding.apply {
            btnSignUp.setOnClickListener {
                if (etId.text.length in 6..10 && etPw.text.length in 8..12) { //회원가입 조건 ID 6~10 / 비밀번호 8~12
                    intent.apply {
                        putExtra( //UserData 형태로 Intent 전달
                            "userdata",
                            UserData(
                                etId.text.toString(),
                                etPw.text.toString(),
                                etMbti.text.toString()
                            )
                        )
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    Snackbar.make(binding.root, "회원가입이 불가 합니다..", Snackbar.LENGTH_SHORT).apply {
                        anchorView = binding.btnSignUp
                    }.show()

                }
            }
        }
    }
}