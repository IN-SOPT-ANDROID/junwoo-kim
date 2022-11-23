package org.sopt.sample.domain.repository

import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.data.model.dto.ResponseSignUpDTO
import retrofit2.Response

interface AuthRepository {
    suspend fun postSingup(dto: RequestSingUpDTO): Response<ResponseSignUpDTO>
    suspend fun postLogin(dto: RequestLoginDTO): Response<ResponseLoginDTO>
}