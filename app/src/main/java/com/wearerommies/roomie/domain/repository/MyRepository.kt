package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.MyPageEntity

interface MyRepository {
    suspend fun getMyPageData(): Result<MyPageEntity>
}