package com.wearerommies.roomie.domain.entity

data class RoomCardEntity(
    val houseId: Int,
    val monthlyRent: String,
    val deposit: String,
    val occupancyType: String,
    val location: String,
    val genderPolicy: String,
    val locationDescription: String,
    val isPinned: Boolean = true,
    val moodTag: String,
    val contract_term: Int,
    val mainImgUrl: String,
)