package org.sopt.sample.application

import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import retrofit2.Response
import retrofit2.http.GET

interface ReqresApi { // 서비스 부분도 suspend여야 의미가 있다
    @GET("api/users?page=2")
    suspend fun getList(): Response<ResponseReqresListDTO>
}