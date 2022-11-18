package org.sopt.sample.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivitySignUpBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.login.LoginActivity
import org.sopt.sample.presentation.model.UserData
import org.sopt.sample.presentation.signup.viewmodel.SingUpViewModel
import org.sopt.sample.presentation.util.makeSnackbar

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {


    private val signUpViewModel: SingUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewmodel = signUpViewModel
        addObserve()
    }

    private fun addObserve() { //button 이 enabled되고 그 이후 click되면 finish
        signUpViewModel.success.observe(this) {
            if (it) finish()
            else binding.root.makeSnackbar("서버통신실패!")
        }
    }

    private fun addListener() {
//        binding.btnSignUp.setOnSingleClickListener { //TODO 세미나4 필수과제 추후 삭제
//            ApiFactory.loginService
//                .signup(
//                    RequestSingUpDTO(
//                        binding.etId.text.toString(),
//                        binding.etPw.text.toString(),
//                        binding.etName.text.toString()
//                    )
//                ).enqueue(
//                    object : Callback<ResponseSignUpDTO> {
//                        override fun onResponse(
//                            call: Call<ResponseSignUpDTO>,
//                            response: Response<ResponseSignUpDTO>
//                        ) {
//                            if (response.isSuccessful) {
//                                Timber.e(response.body().toString())
//                            } else {
//                                Timber.e(response.body().toString())
//                            }
//                        }
//
//                        override fun onFailure(call: Call<ResponseSignUpDTO>, t: Throwable) {
//                            Timber.e(t)
//                        }
//                    }
//                )
//     }
    }

//    private fun withLiveData() { //TODO 팟장님 코드리뷰 해주신거 처럼 최대한 viewmodel에서 로직 처리 해줌 삭제예정
//        binding.apply {
//            etId.addTextChangedListener {
//                activationId.value = etId.text.length in 6..10
//            }
//            etPw.addTextChangedListener {
//                activationPw.value = etPw.text.length in 8..12
//            }
//        }
//    }
//
//    private fun addObserve() {
//        activationId.observe(this, Observer { //주로 DataBinding 갱신을 해주는 것으로 알고 있음
//            binding.enabled = (activationId.value == true && activationPw.value == true)
//        })
//
//        activationPw.observe(this, Observer {
//            binding.enabled = (activationId.value == true && activationPw.value == true)
//        })
//    }


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
                                etName.text.toString()
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