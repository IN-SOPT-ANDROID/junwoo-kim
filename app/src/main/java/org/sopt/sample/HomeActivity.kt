package org.sopt.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.data.UserData
import org.sopt.sample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult()
    }

    private fun getResult() {
        val userData =
            if (android.os.Build.VERSION.SDK_INT >= 33)
                intent.getParcelableExtra("userdata", UserData::class.java)!!
            else
                intent.getParcelableExtra("userdata")!!
        binding.userdata = userData
    }

}