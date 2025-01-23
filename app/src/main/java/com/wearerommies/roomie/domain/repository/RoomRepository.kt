package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.TourEntity

interface RoomRepository {
    suspend fun applyRoomTour(tourData: TourEntity): Result<Unit>
}