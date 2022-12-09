package org.sopt.sample.data.repository

import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt.sample.data.datasource.MusicService
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.data.model.dto.ResponsePostMusicDTO
import org.sopt.sample.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val musicService: MusicService
) : MusicRepository {
    override suspend fun getMusicList(): ResponseGetMusicDTO {
        return musicService.getMusicList()
    }

    override suspend fun postMusic(
        image: MultipartBody.Part?,
        request: RequestBody,
        //request: HashMap<String, RequestBody>,
    ): ResponsePostMusicDTO {
        return musicService.postMusic(image, request)
    }
}