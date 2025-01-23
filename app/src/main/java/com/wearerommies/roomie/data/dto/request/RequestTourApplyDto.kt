package com.wearerommies.roomie.data.dto.request

import com.wearerommies.roomie.domain.entity.TourEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTourApplyDto(
    @SerialName("birth")
    val birth: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("houseId")
    val houseId: Long,
    @SerialName("message")
    val message: String?,
    @SerialName("name")
    val name: String,
    @SerialName("phoneNumber")
    val phoneNumber: String,
    @SerialName("preferredDate")
    val preferredDate: String,
    @SerialName("roomId")
    val roomId: Long
)

fun TourEntity.toDto() = RequestTourApplyDto(
    birth = birthDate,
    gender = gender,
    houseId = houseId,
    message = message,
    name = name,
    phoneNumber = phoneNumber,
    preferredDate = preferredDate,
    roomId = roomId
)