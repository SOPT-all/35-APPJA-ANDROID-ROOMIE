package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.DetailHouseImageEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDetailHouseImageDto(
    @SerialName("images")
    val images: Images
) {
    @Serializable
    data class Images(
        @SerialName("mainImgUrl")
        val mainImgUrl: String,
        @SerialName("mainImgDescription")
        val mainImgDescription: String,
        @SerialName("facilityImgUrls")
        val facilityImgUrls: List<String>,
        @SerialName("facilityImgDescription")
        val facilityImgDescription: String,
        @SerialName("floorImgUrl")
        val floorImgUrl: String
    )
    fun toEntity() = DetailHouseImageEntity(
        mainImageUrl = images.mainImgUrl,
        mainImageDescription = images.mainImgDescription,
        facilityImageUrls = images.facilityImgUrls,
        facilityImageDescription = images.facilityImgDescription,
        floorImageUrl = images.floorImgUrl
    )
}
