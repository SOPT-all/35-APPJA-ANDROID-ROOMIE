package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.HomeDataEntity

interface HomeRepository {
    suspend fun getHomeData() : Result<HomeDataEntity>
}