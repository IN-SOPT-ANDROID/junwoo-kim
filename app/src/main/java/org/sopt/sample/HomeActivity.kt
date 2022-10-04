package org.sopt.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.data.UserData
import org.sopt.sample.databinding.ActivityIntroduceBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroduceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroduceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult()
    }

    private fun getResult() {
        val userData =
            if (android.os.Build.VERSION.SDK_INT >= 33)
                intent.getParcelableExtra("userdata", UserData::class.java)!!
            else
                intent.getParcelableExtra("userdata")!!

        binding.apply {
            tvName.text = "이름 : ${userData.id} "
            tvMbti.text = "MBTI : ${userData.mbti}"
        }
    }

}