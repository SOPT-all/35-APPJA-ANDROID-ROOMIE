package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.HomeDataSource
import com.wearerommies.roomie.domain.entity.HomeDataEntity
import com.wearerommies.roomie.domain.repository.HomeRepository
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getHomeData(): Result<HomeDataEntity> =
        runCatching {
            homeDataSource.getHomeData().data.toEntity()
        }
}