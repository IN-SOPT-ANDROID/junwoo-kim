package org.sopt.sample

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.model.UserData
import org.sopt.sample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var getResultInfo: ActivityResultLauncher<Intent>
    private lateinit var userData: UserData
    private lateinit var authPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
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
                        userData = if (android.os.Build.VERSION.SDK_INT >= 33) //getParcelableExtra 함수 deprecated 대처
                            it.data!!.getParcelableExtra("userdata", UserData::class.java)!!
                        else
                            it.data!!.getParcelableExtra("userdata")!!
                }
            }
        }
    }

    private fun loginListener() { // login button listener
        binding.apply {
            btnLogin.setOnClickListener {
                if (::userData.isInitialized) {
                    if (etId.text.toString() == userData.id && etPw.text.toString() == userData.pw) { 
                        //회원가입 정보와 입력한 정보가 맞을 경우 Home화면 이동 및 SharedPreference 편집
                        authPreferences.edit().apply {
                            putString("id", userData.id)
                            putString("pw", userData.pw)
                            putString("mbti", userData.mbti)
                        }.apply()
                        Toast.makeText(this@LoginActivity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT)
                            .show()
                        startHomeActivity(userData)
                    }
                }
            }
        }
    }


    private fun startHomeActivity(userData: UserData) { // HomeActivity이동을  위한 UserData, IntentFlag 설정
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK) //이전 Activity들이 백스택에 남지 않도록 설정
            .apply { putExtra("userdata", userData) })
    }

}