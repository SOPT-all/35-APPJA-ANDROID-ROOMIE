package com.wearerommies.roomie.data.dto.response

import com.wearerommies.roomie.domain.entity.DetailRoomEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDetailRoomDto(
    @SerialName("rooms")
    val rooms: List<Room>
) {
    @Serializable
    data class Room(
        @SerialName("roomId")
        val roomId: Long,
        @SerialName("name")
        val name: String,
        @SerialName("facility")
        val facility: List<String>,
        @SerialName("status")
        val status: Boolean,
        @SerialName("mainImageUrl")
        val mainImageUrl: List<String>
    )

    fun toEntity() = rooms.map {
        DetailRoomEntity(
            roomId = it.roomId,
            name = it.name,
            facility = it.facility,
            status = it.status,
            imagesUrl = it.mainImageUrl
        )
    }
}
