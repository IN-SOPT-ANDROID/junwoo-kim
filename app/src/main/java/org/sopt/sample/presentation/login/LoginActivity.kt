package org.sopt.sample.presentation.login

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.sopt.sample.R
import org.sopt.sample.application.ApiFactory
import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.databinding.ActivityLoginBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.home.HomeActivity
import org.sopt.sample.presentation.model.UserData
import org.sopt.sample.presentation.signup.SignUpActivity
import org.sopt.sample.presentation.util.makeSnackbar
import org.sopt.sample.presentation.util.setOnSingleClickListener

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private lateinit var getResultInfo: ActivityResultLauncher<Intent>
    private lateinit var userData: UserData
    private lateinit var authPreferences: SharedPreferences

    private val authService by lazy { ApiFactory.loginService }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        authPreferences = getSharedPreferences("autologin", Activity.MODE_PRIVATE)

        authPreferenceCheck()
        loginListener()
        singUpListener()
    }

    private fun authPreferenceCheck() { // SharedPreference 체크 함수
        if (authPreferences.getString("id", null) != null) {
            userData = UserData(
                authPreferences.getString("id", null).toString(),
                authPreferences.getString("pw", null).toString(),
                authPreferences.getString("mbti", null).toString(),
            )
            // 이전 로그인 기록이 있을 경우 바로 HomeActivity로 이동
            startHomeActivity(userData)
        }
    }

    private fun singUpListener() { // signup button listener
        binding.apply {
            btnSignUp.setOnClickListener {
                getResultInfo.launch(Intent(this@LoginActivity, SignUpActivity::class.java))
            }
            getResultInfo =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) {
                        Snackbar.make(binding.root, "회원가입이 완료되었습니다.", Snackbar.LENGTH_SHORT)
                            .show()
                        userData =
                            if (android.os.Build.VERSION.SDK_INT >= 33) //getParcelableExtra 함수 deprecated 대처
                                it.data!!.getParcelableExtra("userdata", UserData::class.java)!!
                            else
                                it.data!!.getParcelableExtra("userdata")!!
                    }
                }
        }
    }

    private fun loginListener() { // login button listener
        binding.apply {
            btnLogin.setOnSingleClickListener {
                // 비동기로 로그인 하는 함수
                // mvvm관점으로 본다면 view를 어쨋든 가지고 있기때문에 뷰모델에서 동작하게끔 해주어야 한다고 생각하지만
                // 액티비티단에서 lifecyclescope 동작을 한번 해보려고 다음과 같이 작성해봤습니다!!
                lifecycleScope.launch {
                    val response = authService.login(
                        RequestLoginDTO(
                            binding.etId.text.toString(), binding.etPw.text.toString()
                        )
                    )
                    if (response.isSuccessful) {
                        startActivity(
                            Intent(this@LoginActivity, HomeActivity::class.java)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        ) //이전 Activity들이 백스택에 남지 않도록 설정
                    } else {
                        binding.root.makeSnackbar("로그인에 실패하였습니다.")
                    }
                }


//                authService.login( //TODO 세미나4 필수과제 추후 삭제
//                    RequestLoginDTO(
//                        binding.etId.text.toString(), binding.etPw.text.toString()
//                    )
//                ).enqueue(//해당 비동기 코드는 대부분 다른 동기코드보다 늦게 실행된다.
//                    object : Callback<ResponseLoginDTO> {
//                        //Callback은 Retrofit에 있는애로 사용해야함
//                        override fun onResponse(
//                            call: Call<ResponseLoginDTO>,
//                            response: Response<ResponseLoginDTO>
//                        ) {//로그인 성공 기준 함수
//                            if (response.isSuccessful) {
//                                //코드가 2xx의 경우 response.isSuecessful이 작동
//                                val result = response.body()
//                                Toast.makeText(
//                                    this@LoginActivity,
//                                    "로그인에 성공했습니다.",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                                startActivity(Intent(this@LoginActivity, HomeActivity::class.java)
//                                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)) //이전 Activity들이 백스택에 남지 않도록 설정
//                            } else {
//                                // 2xx제외 4xx 5xx등 응답코드가 다른 경우에 작동하는 애들
//                                //즉,통신은 잘 이루어지지만 응답코드가 정상이 아닌경우
//                                Toast.makeText(
//                                    this@LoginActivity,
//                                    "로그인에 살패했습니다.",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//                        }
//
//                        override fun onFailure(call: Call<ResponseLoginDTO>, t: Throwable) {
//                            //로그인 실패 기준 함수
//                            //얘는 서버 통신이 아예 끊길떄의 경우
//                            Toast.makeText(this@LoginActivity, "서버통신에 살패했습니다.", Toast.LENGTH_SHORT)
//                                .show()
//                        }
//                    }
//                )
//

//                if (::userData.isInitialized) { //TODO 이전세미나 추후 삭제
//                    if (etId.text.toString() == userData.id && etPw.text.toString() == userData.pw) {
//                        //회원가입 정보와 입력한 정보가 맞을 경우 Home화면 이동 및 SharedPreference 편집
//                        authPreferences.edit().apply {
//                            putString("id", userData.id)
//                            putString("pw", userData.pw)
//                            putString("mbti", userData.mbti)
//                        }.apply()
//                        Toast.makeText(this@LoginActivity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT)
//                            .show()
//                        startHomeActivity(userData)
//                    }
//                }
            }
        }
    }


    private fun startHomeActivity(userData: UserData) { // HomeActivity이동을  위한 UserData, IntentFlag 설정
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) //이전 Activity들이 백스택에 남지 않도록 설정
            .apply { putExtra("userdata", userData) })
    }

}