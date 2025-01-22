package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.DetailEntity
import com.wearerommies.roomie.domain.entity.DetailHouseImageEntity
import com.wearerommies.roomie.domain.entity.DetailRoomEntity
import com.wearerommies.roomie.domain.entity.MoodCardEntity
import com.wearerommies.roomie.domain.entity.RoomCardEntity

interface HouseRepository {
    suspend fun getMoodLists(moodTag: String): Result<MoodCardEntity>
    suspend fun getBookmarkLists(): Result<List<RoomCardEntity>>
    suspend fun bookmarkHouse(houseId: Long): Result<Boolean>
    suspend fun getHouseDetail(houseId: Long): Result<DetailEntity>
    suspend fun getRoomDetail(houseId: Long): Result<List<DetailRoomEntity>>
    suspend fun getHouseDetailImage(houseId: Long): Result<DetailHouseImageEntity>
}