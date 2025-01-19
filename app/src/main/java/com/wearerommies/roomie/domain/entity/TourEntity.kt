package com.wearerommies.roomie.domain.entity

import java.util.Date

data class TourEntity(
    val name: String ,
    val birth: Date,
    val gender: String,
    val phoneNumber: String,
    val preferredDate: Date,
    val message: String,
    val roomId: Int,
    val houseId: Int
)