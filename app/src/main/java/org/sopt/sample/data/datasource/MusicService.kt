package org.sopt.sample.data.datasource

import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.sopt.sample.data.model.dto.RequestPostMusic
import org.sopt.sample.data.model.dto.ResponseGetMusicDTO
import org.sopt.sample.data.model.dto.ResponsePostMusicDTO
import retrofit2.http.*

interface MusicService {
    @GET("music/list")
    suspend fun getMusicList(): ResponseGetMusicDTO

    @Multipart
    @POST("music")
    suspend fun postMusic(
        @PartMap body: HashMap<String, RequestPostMusic>,
        @Part file: MultipartBody.Part
    ): ResponsePostMusicDTO
}