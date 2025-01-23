package com.wearerommies.roomie.domain.entity

data class DetailHouseImageEntity(
    val mainImageUrl: String,
    val mainImageDescription: String,
    val facilityImageUrls: List<String>,
    val facilityImageDescription: String,
    val floorImageUrl: String
)