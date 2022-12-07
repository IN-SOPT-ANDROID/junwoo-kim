package org.sopt.sample.data.repository

import okhttp3.MultipartBody
import org.sopt.sample.data.datasource.MusicService
import org.sopt.sample.data.model.dto.RequestPostMusic
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
        map: HashMap<String, RequestPostMusic>,
        image: MultipartBody.Part
    ): ResponsePostMusicDTO {
        return musicService.postMusic(map, image)
    }
}