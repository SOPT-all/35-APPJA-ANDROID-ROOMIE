package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.RoomCardEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBookmarkListDto(
    @SerialName("pinnedHouses")
    val pinnedHouses: List<PinnedHouse>
) {
    @Serializable
    data class PinnedHouse(
        @SerialName("contractTerm")
        val contractTerm: Int,
        @SerialName("deposit")
        val deposit: String,
        @SerialName("genderPolicy")
        val genderPolicy: String,
        @SerialName("houseId")
        val houseId: Long,
        @SerialName("isPinned")
        val isPinned: Boolean,
        @SerialName("location")
        val location: String,
        @SerialName("locationDescription")
        val locationDescription: String,
        @SerialName("mainImgUrl")
        val mainImgUrl: String,
        @SerialName("monthlyRent")
        val monthlyRent: String,
        @SerialName("moodTag")
        val moodTag: String,
        @SerialName("occupancyTypes")
        val occupancyTypes: String
    ) {
        fun toEntity() = RoomCardEntity(
            houseId = houseId,
            monthlyRent = monthlyRent,
            deposit = deposit,
            occupancyType = occupancyTypes,
            location = location,
            genderPolicy = genderPolicy,
            locationDescription = locationDescription,
            isPinned = isPinned,
            moodTag = moodTag,
            contractTerm = contractTerm,
            mainImgUrl = mainImgUrl
        )
    }

    fun toEntity() = pinnedHouses.map { it.toEntity() }
}
