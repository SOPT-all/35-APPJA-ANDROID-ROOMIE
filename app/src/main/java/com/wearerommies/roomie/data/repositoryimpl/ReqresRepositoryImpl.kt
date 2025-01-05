package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.ReqresDataSource
import com.wearerommies.roomie.data.mapper.todomain.toReqresEntity
import com.wearerommies.roomie.domain.entity.ReqresEntity
import com.wearerommies.roomie.domain.repository.ReqresRepository
import javax.inject.Inject

class ReqresRepositoryImpl @Inject constructor(
    private val reqresDataSource: ReqresDataSource
) : ReqresRepository {
    override suspend fun getReqresLists(page: Int): Result<List<ReqresEntity>> =
        runCatching {
            reqresDataSource.getReqresLists(page).toReqresEntity()
        }
}
