package org.sopt.sample.application

import org.sopt.sample.data.model.dto.ResponseReqresList
import retrofit2.Call
import retrofit2.http.POST

interface ReqresApi {
    @POST("api/users?page=2")
    fun signup(): Call<ResponseReqresList>
}