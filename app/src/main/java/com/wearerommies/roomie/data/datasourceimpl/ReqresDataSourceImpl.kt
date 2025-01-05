package com.wearerommies.roomie.data.datasourceimpl

import com.wearerommies.roomie.data.datasource.ReqresDataSource
import com.wearerommies.roomie.data.dto.response.ResponseReqresDto
import com.wearerommies.roomie.data.service.ReqresService
import javax.inject.Inject

class ReqresDataSourceImpl @Inject constructor(
    private val reqresService: ReqresService
) : ReqresDataSource {
    override suspend fun getReqresLists(page: Int): ResponseReqresDto =
        reqresService.getReqresLists(page)
}
