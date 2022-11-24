package org.sopt.sample.data.repository

import org.sopt.sample.application.ApiFactory
import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.data.model.dto.ResponseSignUpDTO
import org.sopt.sample.domain.repository.AuthRepository
import retrofit2.Response

class AuthRepositoryImpl :AuthRepository {
    override suspend fun postSignUp(dto: RequestSingUpDTO): Response<ResponseSignUpDTO> {
        return ApiFactory.loginService.signup(dto)
    }

    override suspend fun postLogin(dto: RequestLoginDTO): Response<ResponseLoginDTO> {
        return ApiFactory.loginService.login(dto)
    }
}