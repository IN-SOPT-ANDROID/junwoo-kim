package org.sopt.sample.application

import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi { // 서비스 부분도 suspend여야 의미가 있다
    @GET("api/users?")
    suspend fun getReqresList(@Query("page") page: Int = 2): Response<ResponseReqresListDTO>
}