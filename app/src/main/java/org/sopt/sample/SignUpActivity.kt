package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.data.UserData
import org.sopt.sample.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var resultIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resultIntent = Intent(this, LoginActivity::class.java)
        init()
    }

    private fun init() {
        binding.apply {
            btnSignUp.setOnClickListener {
                if (etId.text.length in 6..10 && etPw.text.length in 8..12) {
                    resultIntent.apply {
                        putExtra(
                            "userdata",
                            UserData(
                                etId.text.toString(),
                                etPw.text.toString(),
                                etMbti.text.toString()
                            )
                        )
                    }
                    setResult(RESULT_OK,resultIntent)
                    finish()
                } else {}//Snackbar.make(binding.root, "회원가입이 불가 합니다..", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}