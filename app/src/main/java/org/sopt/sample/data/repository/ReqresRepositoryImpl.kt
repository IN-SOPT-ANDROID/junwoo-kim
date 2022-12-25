package org.sopt.sample.data.repository

import org.sopt.sample.data.datasource.ReqresApi
import org.sopt.sample.data.model.dto.ResponseReqresListDTO
import org.sopt.sample.domain.repository.ReqresRepository
import retrofit2.Response
import javax.inject.Inject

class ReqresRepositoryImpl @Inject constructor(
    private val reqresService: ReqresApi
) : ReqresRepository {
    override suspend fun getList(page: Int): Response<ResponseReqresListDTO> {
        return reqresService.getReqresList(page)
    }
}