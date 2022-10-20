package org.sopt.sample.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityHomeBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.home.fragment.GalleryFragment
import org.sopt.sample.presentation.home.fragment.HomeFragment
import org.sopt.sample.presentation.home.fragment.SearchFragment
import org.sopt.sample.presentation.model.UserData

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getResult()
        init()
        setBottomNav()
    }

    private fun init() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container_home)
        if (currentFragment == null) {
            transactionFragment(HomeFragment.newInstance())
        }
    }

    private fun setBottomNav() {
        binding.navBottomHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    transactionFragment(HomeFragment.newInstance())
                }
                R.id.nav_gallery -> {
                    transactionFragment(GalleryFragment.newInstance())
                }
                R.id.nav_search -> {
                    transactionFragment(SearchFragment.newInstance())
                }
            }
            return@setOnItemSelectedListener true
        }

        binding.navBottomHome.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.nav_home -> { //현재 프래그먼트가 home이면 리싸이클러뷰 스크롤 이동
                    HomeFragment.setScroll()
                    return@setOnItemReselectedListener
                }
                else -> { // 다른프래그먼트였다면 홈 프래그먼트로 이동
                    transactionFragment(HomeFragment.newInstance())
                }
            }
        }
    }


    private fun transactionFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_home, fragment)
            .commit()
        return true
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