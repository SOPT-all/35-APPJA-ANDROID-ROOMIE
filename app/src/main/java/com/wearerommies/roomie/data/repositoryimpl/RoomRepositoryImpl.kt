package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.RoomDataSource
import com.wearerommies.roomie.data.dto.request.toDto
import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val roomDataSource: RoomDataSource
): RoomRepository {
    override suspend fun applyRoomTour(tourData: TourEntity): Result<Unit> =
        runCatching {
            roomDataSource.postRoomTourApply(
                roomId = tourData.roomId,
                request = tourData.toDto()
            )
        }
}