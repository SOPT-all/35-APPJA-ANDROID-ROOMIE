package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.ResponseReqresDto

interface ReqresDataSource {
    suspend fun getReqresLists(page: Int): ResponseReqresDto
}
