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
import org.sopt.sample.presentation.util.makeSnackbar
import org.sopt.sample.presentation.util.stringOf

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
        with(binding) {
            viewmodel = galleryViewModel
            lifecycleOwner = viewLifecycleOwner
            btnUpload.setOnClickListener {
                launcher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
        }
        setAdapter()
        addObserve()
    }

    private fun setAdapter() {
        musicAdapter = MusicAdapter(requireContext())
        binding.rcvMusic.adapter = musicAdapter
    }

    private fun addObserve() {
        with(galleryViewModel) {
            musicList.observe(viewLifecycleOwner) {
                musicAdapter.submitList(it.reversed())
            }
            success.observe(viewLifecycleOwner) {
                if (it) { // 성공시 스낵바 및 리스트 갱신
                    binding.root.makeSnackbar(requireContext().stringOf(R.string.upload_success))
                    getMusicList()
                } else binding.root.makeSnackbar(requireContext().stringOf(R.string.upload_fail))
            }
        }
    }
}