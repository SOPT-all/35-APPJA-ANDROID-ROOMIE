package com.wearerommies.roomie.domain.entity

data class DetailRoomEntity(
    val roomId: Long,
    val name: String,
    val facility: List<String>,
    val status: Boolean,
    val imagesUrl: List<String>
)