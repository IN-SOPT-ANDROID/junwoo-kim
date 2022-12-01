package org.sopt.sample.presentation.login

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.R
import org.sopt.sample.data.repository.AuthRepositoryImpl
import org.sopt.sample.databinding.ActivityLoginBinding
import org.sopt.sample.presentation.base.BindingSplashActivity
import org.sopt.sample.presentation.home.HomeActivity
import org.sopt.sample.presentation.login.viewmodel.LoginViewModel
import org.sopt.sample.presentation.model.UserData
import org.sopt.sample.presentation.signup.SignUpActivity
import org.sopt.sample.presentation.util.AuthViewModelFactory
import org.sopt.sample.presentation.util.makeSnackbar

class LoginActivity : BindingSplashActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private lateinit var getResultInfo: ActivityResultLauncher<Intent>
    private lateinit var userData: UserData
    private lateinit var authPreferences: SharedPreferences

    private lateinit var loginViewModel: LoginViewModel
    private val authRepository = AuthRepositoryImpl()

    override fun loadSplash() {
        installSplashScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        authPreferences = getSharedPreferences("autologin", Activity.MODE_PRIVATE)

        binding.lifecycleOwner = this
        val factory = AuthViewModelFactory(authRepository)
        loginViewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.viewmodel = loginViewModel

        //authPreferenceCheck()
        addObserve()
        singUpListener()
    }

    private fun addObserve() {
        loginViewModel.success.observe(this) { //로그인 성공되면 자동으로 Home이동
            if (it) {
                startActivity(
                    Intent(this@LoginActivity, HomeActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                )
            } else binding.root.makeSnackbar("서버통신실패!")
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


    private fun startHomeActivity(userData: UserData) { // HomeActivity이동을  위한 UserData, IntentFlag 설정
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) //이전 Activity들이 백스택에 남지 않도록 설정
            .apply { putExtra("userdata", userData) })
    }



}