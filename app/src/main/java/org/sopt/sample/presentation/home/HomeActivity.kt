package org.sopt.sample.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.sopt.sample.R
import org.sopt.sample.presentation.model.UserData
import org.sopt.sample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getResult()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_home, HomeFragment.newInstance())
                .commit()
        }
        binding.navBottomHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_home, HomeFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_gallery -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_home, GalleryFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
                R.id.nav_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_home, SearchFragment.newInstance())
                        .commit()
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }
        binding.navBottomHome.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    HomeFragment.setScroll()
                    return@setOnItemReselectedListener
                }
            }
        }
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