package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.HouseDataSource
import com.wearerommies.roomie.domain.entity.BookmarkEntity
import com.wearerommies.roomie.domain.entity.DetailEntity
import com.wearerommies.roomie.domain.entity.DetailHouseImageEntity
import com.wearerommies.roomie.domain.entity.DetailRoomEntity
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

    override suspend fun bookmarkHouse(houseId: Long): Result<BookmarkEntity> =
        runCatching {
            houseDataSource.bookmarkHouse(houseId = houseId).data.toEntity()
        }

    override suspend fun getHouseDetail(houseId: Long): Result<DetailEntity> =
        runCatching {
            houseDataSource.getHouseDetail(houseId = houseId).data.toEntity()
        }

    override suspend fun getRoomDetail(houseId: Long): Result<List<DetailRoomEntity>> =
        runCatching {
            houseDataSource.getRoomDetail(houseId = houseId).data.toEntity()
        }

    override suspend fun getHouseDetailImage(houseId: Long): Result<DetailHouseImageEntity> =
        runCatching {
            houseDataSource.getHouseDetailImage(houseId = houseId).data.toEntity()
        }
}
