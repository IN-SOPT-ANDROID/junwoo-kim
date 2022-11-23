package org.sopt.sample.data.repository

import org.sopt.sample.application.ApiFactory
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.domain.repository.ReqresRepository
import retrofit2.Response

class ReqresRepositoryImpl : ReqresRepository {
    override suspend fun getList(): Response<ResponseReqresListDTO> {
        return ApiFactory.reqresService.getReqresList()
    }
}