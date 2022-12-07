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

    //music List from api
    private val _musicList = MutableLiveData<List<ResponseGetMusicDTO.MusicData>>()
    val musicList get() = _musicList

    //post success
    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> get() = _success

    //data
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
                _success.value = it.statusCode == 201
            }.onFailure {
                Timber.e(it)
                _success.value = false
            }
        }
    }

}