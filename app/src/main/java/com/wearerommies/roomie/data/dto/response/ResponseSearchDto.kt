package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.SearchResultEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchDto(
    @SerialName("locations")
    val locations: List<Location>
) {
    @Serializable
    data class Location(
        @SerialName("x")
        val x: Float,
        @SerialName("y")
        val y: Float,
        @SerialName("location")
        val location: String,
        @SerialName("address")
        val address: String,
        @SerialName("roadAddress")
        val roadAddress: String
    ) {
        fun toEntity() = SearchResultEntity(
            x = this.x,
            y = this.y,
            location = this.location,
            address = this.address,
            roadAddress = this.roadAddress
        )
    }

    fun toEntity() = locations.map { it.toEntity() }
}

