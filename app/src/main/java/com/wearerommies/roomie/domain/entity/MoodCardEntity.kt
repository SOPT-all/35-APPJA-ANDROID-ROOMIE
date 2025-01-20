package com.wearerommies.roomie.domain.entity

data class MoodCardEntity(
    val moodTag: String,
    val houses: List<House>,
) {
    data class House(
        val houseId: Long,
        val monthlyRent: String,
        val deposit: String,
        val occupancyTypes: String,
        val location: String,
        val genderPolicy: String,
        val locationDescription: String,
        val isPinned: Boolean,
        val contractTerm: Long,
        val mainImgUrl: String,
    )
}