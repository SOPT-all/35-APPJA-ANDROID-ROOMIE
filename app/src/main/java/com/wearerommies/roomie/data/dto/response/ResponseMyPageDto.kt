package com.wearerommies.roomie.data.dto.response


import com.wearerommies.roomie.domain.entity.MyPageEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyPageDto(
    @SerialName("name")
    val name: String
) {
    fun toEntity() = MyPageEntity(
        name = name
    )
}