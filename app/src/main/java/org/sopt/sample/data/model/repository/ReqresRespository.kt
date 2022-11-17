package org.sopt.sample.data.model.repository

import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import retrofit2.Response

interface ReqresRespository {
    suspend fun getList():Response<ResponseReqresListDTO>
}