package org.sopt.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.model.UserData
import org.sopt.sample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult()
    }

    private fun getResult() { // LoginActivity가 보낸 intent 수신
        val userData = //getParcelableExtra 함수 deprecated 대처
            if (android.os.Build.VERSION.SDK_INT >= 33)
                intent.getParcelableExtra("userdata", UserData::class.java)!!
            else
                intent.getParcelableExtra("userdata")!!
        binding.userdata = userData // 데이터바인딩
    }

}