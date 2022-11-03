package org.sopt.sample.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.login.LoginActivity
import org.sopt.sample.presentation.model.UserData

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private var activationId = MutableLiveData<Boolean>(false)
    private var activationPw = MutableLiveData<Boolean>(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.enabled = false
        withLiveData()
        addObserve()
    }

    private fun withLiveData() {
        binding.apply {
            etId.addTextChangedListener {
                activationId.value = etId.text.length in 6..10
            }
            etPw.addTextChangedListener {
                activationPw.value = etPw.text.length in 8..12
            }
        }
    }

    private fun addObserve() {
        activationId.observe(this, Observer { //주로 DataBinding 갱신을 해주는 것으로 알고 있음
            binding.enabled = (activationId.value == true && activationPw.value == true)
        })

        activationPw.observe(this, Observer {
            binding.enabled = (activationId.value == true && activationPw.value == true)
        })
    }


    private fun noLiveData() { // 라이브 데이터를 사용하지 않았을때의 동작
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