package com.wearerommies.roomie.domain.entity

data class DetailEntity(
    val houseInfo: HouseInfo,
    val rooms: List<Room>,
    val roommates: List<RoomMate>?
) {
    data class HouseInfo(
        val houseId: Long,
        val name: String,
        val mainImageUrl: String,
        val monthlyRent: String,
        val deposit: String,
        val location: String,
        val occupancyTypes: String,
        val occupancyStatus: String,
        val genderPolicy: String,
        val contractTerm: Int,
        val moodTags: List<String>,
        val roomMood: String,
        val groundRule: List<String>,
        val maintenanceCost: Int,
        val isPinned: Boolean,
        val safetyLivingFacility: List<String>,
        val kitchenFacility: List<String>
    )

    data class Room(
        val roomId: Long,
        val name: String,
        val status: Boolean,
        val isTourAvailable: Boolean,
        val occupancyType: Int,
        val gender: String,
        val deposit: Int,
        val prepaidUtilities: Int,
        val monthlyRent: Int,
        val contractPeriod: String?,
        val managementFee: String
    )

    data class RoomMate(
        val name: String,
        val age: String,
        val job: String,
        val mbti: String,
        val sleepTime: String,
        val activityTime: String
    )
}

