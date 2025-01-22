package com.wearerommies.roomie.domain.entity

data class FilterResultEntity(
    val houseId: Long,
    val x: Float,
    val y: Float,
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
