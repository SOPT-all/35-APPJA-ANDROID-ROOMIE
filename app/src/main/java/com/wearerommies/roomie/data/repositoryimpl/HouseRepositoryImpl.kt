package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.HouseDataSource
import com.wearerommies.roomie.domain.entity.DetailEntity
import com.wearerommies.roomie.domain.entity.MoodCardEntity
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import javax.inject.Inject

internal class HouseRepositoryImpl @Inject constructor(
    private val houseDataSource: HouseDataSource
) : HouseRepository {
    override suspend fun getMoodLists(moodTag: String): Result<MoodCardEntity> =
        runCatching {
            houseDataSource.getMoodLists(moodTag = moodTag).data.toEntity()
        }

    override suspend fun getBookmarkLists(): Result<List<RoomCardEntity>> =
        runCatching {
            houseDataSource.getBookmarkLists().data.toEntity()
        }

    override suspend fun bookmarkHouse(houseId: Long): Result<Boolean> =
        runCatching {
            houseDataSource.bookmarkHouse(houseId = houseId).data
        }

    override suspend fun getHouseDetail(houseId: Long): Result<DetailEntity> =
        runCatching {
            houseDataSource.getHouseDetail(houseId = houseId).data.toEntity()
        }
}
