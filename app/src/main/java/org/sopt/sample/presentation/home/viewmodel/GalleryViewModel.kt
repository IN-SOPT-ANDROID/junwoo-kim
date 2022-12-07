package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.ResponseMusicDTO
import org.sopt.sample.domain.repository.MusicRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val musicRepository: MusicRepository) :
    ViewModel() {

    init {
        getMusicList()
    }

    private val _musicList = MutableLiveData<List<ResponseMusicDTO.MusicData>>()
    val musicList get() = _musicList


    fun getMusicList() {
        viewModelScope.launch {
            kotlin.runCatching { // 코드리뷰 해주신것 처럼 reponse 없이 해보도록
                musicRepository.getMusicList()
            }.onSuccess {
                if (it.statusCode == 200) {
                    _musicList.value = it.data
                }
            }.onFailure {
                Timber.e(it)
            }
        }
    }

}