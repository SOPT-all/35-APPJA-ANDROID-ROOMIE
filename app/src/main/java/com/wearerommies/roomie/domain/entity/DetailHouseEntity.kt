package com.wearerommies.roomie.domain.entity

data class DetailHouseEntity(
    val mainImageUrl: String,
    val mainImageDescription: String,
    val facilityImageUrls: List<String>,
    val facilityImageDescription: String,
    val floorImageUrl: String,
    val rooms: List<DetailRoomImageEntity>
)
