package org.sopt.sample.data.model.repository

import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import retrofit2.Response

interface ReqresRepository {
    suspend fun getList(): Response<ResponseReqresListDTO>
}