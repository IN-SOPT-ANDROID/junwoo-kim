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
        @Part image: MultipartBody.Part?,
        @Part("request") request: RequestBody
        //@PartMap request: HashMap<String, RequestBody>
    ): ResponsePostMusicDTO
}