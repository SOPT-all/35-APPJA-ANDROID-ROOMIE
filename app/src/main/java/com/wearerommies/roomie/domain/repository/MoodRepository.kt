package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.MoodCardEntity

interface MoodRepository {
    suspend fun getMoodLists(moodTag: String): Result<MoodCardEntity>
}