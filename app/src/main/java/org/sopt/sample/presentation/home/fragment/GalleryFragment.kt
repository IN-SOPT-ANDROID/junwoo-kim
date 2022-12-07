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
import org.sopt.sample.presentation.home.adapter.MusicAdapter
import org.sopt.sample.presentation.home.viewmodel.GalleryViewModel
import org.sopt.sample.presentation.util.ContentUriRequestBody

@AndroidEntryPoint
class GalleryFragment : BindingFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private val galleryViewModel: GalleryViewModel by viewModels()
    private val launcher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        binding.ivImg.load(it)
        galleryViewModel.setImageBody(ContentUriRequestBody(requireContext(), it!!))
    }
    private lateinit var musicAdapter: MusicAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = galleryViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.btnUpload.setOnClickListener {
            launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        setAdapter()
        addObserve()
    }

    private fun setAdapter() {
        musicAdapter = MusicAdapter(requireContext())
        binding.rcvMusic.adapter = musicAdapter
    }

    private fun addObserve() {
        galleryViewModel.musicList.observe(viewLifecycleOwner) {
            musicAdapter.submitList(it)
        }
    }
}