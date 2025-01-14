package com.wearerommies.roomie.domain.entity

data class HouseEntity(
    val houseId: Int,
    val x: Double,
    val y: Double,
    val monthlyRent: String,
    val deposit: String,
    val occupancyTypes: String,
    val location: String,
    val genderPolicy: String,
    val locationDescription: String,
    val isPinned: Boolean,
    val moodTag: String,
    val contractTerm: Int,
    val mainImgUrl: String
)
