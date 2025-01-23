package com.wearerommies.roomie.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseTourApplyDto(
    @SerialName("isSuccess")
    val isSuccess: Boolean
)
