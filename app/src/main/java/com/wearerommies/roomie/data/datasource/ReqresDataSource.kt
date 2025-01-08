package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.ResponseReqresDto
import com.wearerommies.roomie.data.service.ReqresService
import javax.inject.Inject

internal class ReqresDataSource @Inject constructor(
    private val reqresService: ReqresService
) {
    suspend fun getReqresLists(page: Int): ResponseReqresDto =
        reqresService.getReqresLists(page)
}
