package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSetListeners()
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
                        userData = if(android.os.Build.VERSION.SDK_INT>=33)
                            it.data!!.getParcelableExtra("userdata",UserData::class.java)!!
                        else
                            it.data!!.getParcelableExtra("userdata")!!
                    }
                }

            btnLogin.setOnClickListener {
                if(::userData.isInitialized){
                    if (etId.text.toString() == userData!!.id && etPw.text.toString() == userData!!.pw)
                        startActivity(Intent(this@LoginActivity, IntroduceActivity::class.java))
                }

            }

        }
    }

}