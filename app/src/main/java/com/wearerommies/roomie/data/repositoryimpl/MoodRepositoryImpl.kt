package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.MoodDataSource
import com.wearerommies.roomie.domain.entity.MoodCardEntity
import com.wearerommies.roomie.domain.repository.MoodRepository
import javax.inject.Inject

internal class MoodRepositoryImpl @Inject constructor(
    private val moodDataSource: MoodDataSource
) : MoodRepository {
    override suspend fun getMoodLists(moodTag: String): Result<MoodCardEntity> =
        runCatching {
            moodDataSource.getMoodLists(moodTag = moodTag).data.toEntity()
        }
}
