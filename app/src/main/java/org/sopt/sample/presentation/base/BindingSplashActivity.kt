package org.sopt.sample.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingSplashActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {
    private var _binding: T? = null
    val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        loadSplash()
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
    }

    abstract fun loadSplash()
}