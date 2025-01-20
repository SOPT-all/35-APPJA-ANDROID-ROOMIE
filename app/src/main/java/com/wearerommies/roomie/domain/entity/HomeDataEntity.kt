package com.wearerommies.roomie.domain.entity

data class HomeDataEntity(
    val name: String,
    val location: String,
    val recentlyViewedHouses: List<RoomCardEntity>
)