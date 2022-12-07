package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentGalleryBinding
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val homeViewModel: HomeViewModel by activityViewModels()
    private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivImg.load(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = homeViewModel
        binding.btnImage.setOnClickListener {
            launcher.launch("image/*")
        }

    }
}