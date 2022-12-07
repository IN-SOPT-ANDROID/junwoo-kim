package org.sopt.sample.domain.repository

import okhttp3.MultipartBody
import org.sopt.sample.data.model.dto.RequestPostMusic
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.data.model.dto.ResponsePostMusicDTO

interface MusicRepository {
    suspend fun getMusicList(): ResponseGetMusicDTO
    suspend fun postMusic(
        map: HashMap<String, RequestPostMusic>,
        image: MultipartBody.Part
    ): ResponsePostMusicDTO
}