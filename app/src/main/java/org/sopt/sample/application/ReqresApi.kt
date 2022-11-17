package org.sopt.sample.application

import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import retrofit2.Response
import retrofit2.http.GET

interface ReqresApi {
    @GET("api/users?page=2")
    fun getList(): Response<ResponseReqresListDTO>
}