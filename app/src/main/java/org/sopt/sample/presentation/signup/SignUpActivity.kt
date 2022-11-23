package org.sopt.sample.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
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

    private fun addObserve() {
        // 경고문구에 따라서 경고창 visible 및 edittext tint 변경
        signUpViewModel.userId.observe(this){
            if(it.isNotEmpty()){
                if(signUpViewModel.activationId.value == true){
                    binding.tvWarnId.visibility = View.GONE
                    binding.etId.background.setTint(this.getColor(R.color.gray))
                }
                else{
                    binding.tvWarnId.visibility = View.VISIBLE
                    binding.etId.background.setTint(this.getColor(R.color.red))
                }
            }else{
                binding.tvWarnId.visibility = View.GONE
                binding.etId.background.setTint(this.getColor(R.color.gray))
            }
        }

        signUpViewModel.success.observe(this) {//button 이 enabled되고 그 이후 click되면 finish
            if (it) finish()
            else binding.root.makeSnackbar("서버통신실패!")
        }
    }

    private fun checkCondition(){

    }

}