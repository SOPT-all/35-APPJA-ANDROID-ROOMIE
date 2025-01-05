package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.ReqresEntity

interface ReqresRepository {
    suspend fun getReqresLists(page: Int): Result<List<ReqresEntity>>
}
