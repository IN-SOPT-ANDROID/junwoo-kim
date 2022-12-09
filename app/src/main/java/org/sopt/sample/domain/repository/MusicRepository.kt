package org.sopt.sample.domain.repository

import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.data.model.dto.ResponsePostMusicDTO

interface MusicRepository {
    suspend fun getMusicList(): ResponseGetMusicDTO
    suspend fun postMusic(
        image: MultipartBody.Part?,
        request: RequestBody,
        //request: HashMap<String, RequestBody>,
        ): ResponsePostMusicDTO
}