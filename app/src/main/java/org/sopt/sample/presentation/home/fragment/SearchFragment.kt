package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentSearchBinding
import org.sopt.sample.presentation.base.BindingFragment


class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}