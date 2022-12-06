package org.sopt.sample.presentation.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.sample.R
import org.sopt.sample.databinding.ActivityHomeBinding
import org.sopt.sample.presentation.base.BindingActivity
import org.sopt.sample.presentation.home.fragment.GalleryFragment
import org.sopt.sample.presentation.home.fragment.HomeFragment
import org.sopt.sample.presentation.home.fragment.SearchFragment
import org.sopt.sample.presentation.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val homeViewModel :HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        //getResult() seminar 3까지만 사용
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
    }


    private fun transactionFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_home, fragment)
            .commit()
        return true
    }

}