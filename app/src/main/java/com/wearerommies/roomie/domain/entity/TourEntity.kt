package com.wearerommies.roomie.domain.entity

data class TourEntity(
    val name: String = "",
    val birth: String = "",
    val gender: String = "",
    val phoneNumber: String = "",
    val preferredDate: String = "",
    val message: String = "",
    val roomId: Long = -1L,
    val houseId: Long = -1L
)