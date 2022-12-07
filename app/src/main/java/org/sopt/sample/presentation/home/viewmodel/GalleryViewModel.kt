package org.sopt.sample.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.domain.repository.MusicRepository
import org.sopt.sample.presentation.util.ContentUriRequestBody
import org.sopt.sample.presentation.util.toRequestBody
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val musicRepository: MusicRepository) :
    ViewModel() {

    init {
        getMusicList()
    }

    private val _musicList = MutableLiveData<List<ResponseGetMusicDTO.MusicData>>()
    val musicList get() = _musicList

    private val _title = MutableLiveData<String>()
    val title get() = _title

    private val _singer = MutableLiveData<String>()
    val singer get() = _singer

    private val _image = MutableLiveData<ContentUriRequestBody>()
    val image: LiveData<ContentUriRequestBody> get() = _image

    fun setImageBody(requestBody: ContentUriRequestBody) {
        _image.value = requestBody
    }

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

    fun postMusic() {
        viewModelScope.launch {
            kotlin.runCatching {
                musicRepository.postMusic(
                    _image.value!!.toFormData(),
                    hashMapOf( // key는 request value는 json 형태의 문자열
                        "request" to "{\"singer\": \"${_singer.value}\",\"title\": \"${_title.value}\"}".toRequestBody()
                    )
                )
            }.onSuccess {
                if (it.statusCode == 201) {
                    //TODO SUCCESS 하나 추가해서 스낵바 띄우고 어댑터 새로고침
                    Timber.d(it.toString())
                } else {
                    Timber.e(it.toString())
                }
            }.onFailure {
                Timber.e(it)
            }
        }
    }

}