package org.sopt.sample.data.datasource

import org.sopt.sample.data.model.dto.ResponseMusicDTO
import retrofit2.http.GET

interface MusicService {
    @GET("music/list")
    suspend fun getMusicList(): ResponseMusicDTO
}