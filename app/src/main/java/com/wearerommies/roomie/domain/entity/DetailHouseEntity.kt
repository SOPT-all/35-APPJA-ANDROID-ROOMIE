package com.wearerommies.roomie.domain.entity

data class DetailHouseEntity(
    val detailHouseImageEntity: DetailHouseImageEntity,
    val rooms: List<DetailRoomEntity>
)
