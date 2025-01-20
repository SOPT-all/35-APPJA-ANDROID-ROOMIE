package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.HomeDataEntity
import com.wearerommies.roomie.domain.entity.MyPageEntity

interface UserRepository {
    suspend fun getHomeData() : Result<HomeDataEntity>
    suspend fun getMyPageData(): Result<MyPageEntity>
}