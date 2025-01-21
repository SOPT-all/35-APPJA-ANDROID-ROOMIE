package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.MoodCardEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMoodDto(
    @SerialName("moodTag")
    val moodTag: String,
    @SerialName("houses")
    val houses: List<House>
) {
    @Serializable
    data class House(
        @SerialName("houseId")
        val houseId: Long,
        @SerialName("monthlyRent")
        val monthlyRent: String,
        @SerialName("deposit")
        val deposit: String,
        @SerialName("occupancyTypes")
        val occupancyTypes: String,
        @SerialName("location")
        val location: String,
        @SerialName("genderPolicy")
        val genderPolicy: String,
        @SerialName("locationDescription")
        val locationDescription: String,
        @SerialName("isPinned")
        val isPinned: Boolean,
        @SerialName("contractTerm")
        val contractTerm: Int,
        @SerialName("mainImgUrl")
        val mainImgUrl: String,
    )

    fun toEntity() = MoodCardEntity(
        moodTag = this.moodTag,
        houses = this.houses.map {
            MoodCardEntity.House(
                contractTerm = it.contractTerm,
                deposit = it.deposit,
                genderPolicy = it.genderPolicy,
                houseId = it.houseId,
                isPinned = it.isPinned,
                location = it.location,
                locationDescription = it.locationDescription,
                mainImgUrl = it.mainImgUrl,
                monthlyRent = it.monthlyRent,
                occupancyTypes = it.occupancyTypes
            )
        }
    )
}
