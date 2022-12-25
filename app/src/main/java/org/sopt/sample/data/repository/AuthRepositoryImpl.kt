package org.sopt.sample.data.repository

import org.sopt.sample.data.datasource.AuthService
import org.sopt.sample.data.model.dto.RequestLoginDTO
import org.sopt.sample.data.model.dto.RequestSingUpDTO
import org.sopt.sample.data.model.dto.ResponseLoginDTO
import org.sopt.sample.data.model.dto.ResponseSignUpDTO
import org.sopt.sample.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepository {
    override suspend fun postSignUp(dto: RequestSingUpDTO): Response<ResponseSignUpDTO> {
        return authService.signup(dto)
    }

    override suspend fun postLogin(dto: RequestLoginDTO): Response<ResponseLoginDTO> {
        return authService.login(dto)
    }
}