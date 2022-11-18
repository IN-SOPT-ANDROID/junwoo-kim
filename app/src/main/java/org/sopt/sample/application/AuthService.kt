package org.sopt.sample.application

import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.data.model.dto.ResponseSignUpDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    //어떤한 액션을 취할 것인지 가장 먼저 작성해야한다.
    @POST("api/user/signin")// BASE_URL마지막에 이미 /가 존재하므로 api부터 시작하는 것이다.
    suspend fun login(@Body request: RequestLoginDTO): Response<ResponseLoginDTO>//지금 Call을 넣어줄떄 Retrofit에 있는 Call객체를 넣어준다.


    @POST("api/user/signup")
    suspend fun signup(@Body request: RequestSingUpDTO): Response<ResponseSignUpDTO>

}