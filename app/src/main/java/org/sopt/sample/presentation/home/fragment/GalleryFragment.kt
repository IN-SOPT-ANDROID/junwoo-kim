package org.sopt.sample.presentation.home.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.sample.R
import org.sopt.sample.databinding.FragmentGalleryBinding
import org.sopt.sample.presentation.base.BindingFragment
import org.sopt.sample.presentation.home.viewmodel.GalleryViewModel
import timber.log.Timber

@AndroidEntryPoint
class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val galleryViewModel: GalleryViewModel by viewModels()
    private val launcher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        binding.ivImg.load(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = galleryViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.btnImage.setOnClickListener {
            launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        galleryViewModel.musicList.observe(viewLifecycleOwner){
            Timber.e(it.toString())
        }

    }
}