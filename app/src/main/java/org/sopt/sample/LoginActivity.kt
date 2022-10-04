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
import org.sopt.sample.data.UserData
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
        authCheck()
        initSetListeners()
    }

    private fun authCheck() {
        if (authPreferences.getString("id", null) != null) {
            userData = UserData(
                authPreferences.getString("id", null).toString(),
                authPreferences.getString("pw", null).toString(),
                authPreferences.getString("mbti", null).toString(),
            )
            startWithIntent(userData)
        }
    }

    private fun initSetListeners() {
        binding.apply {
            btnSignUp.setOnClickListener {
                getResultInfo.launch(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

            getResultInfo =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) {
                        Snackbar.make(binding.root, "회원가입이 완료되었습니다.", Snackbar.LENGTH_SHORT)
                            .show()
                        userData = if (android.os.Build.VERSION.SDK_INT >= 33)
                            it.data!!.getParcelableExtra("userdata", UserData::class.java)!!
                        else
                            it.data!!.getParcelableExtra("userdata")!!
                    }
                }

            btnLogin.setOnClickListener {
                if (::userData.isInitialized) {
                    if (etId.text.toString() == userData!!.id && etPw.text.toString() == userData!!.pw) {
                        authPreferences.edit().apply {
                            putString("id", userData.id)
                            putString("pw", userData.pw)
                            putString("mbti", userData.mbti)
                        }.apply()
                        Toast.makeText(this@LoginActivity, "로그인에 성공했습니다.", Toast.LENGTH_SHORT)
                            .show()
                        startWithIntent(userData)
                    }
                }
            }
        }
    }


    private fun startWithIntent(userData: UserData) {
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            .apply { putExtra("userdata", userData) })
    }

}