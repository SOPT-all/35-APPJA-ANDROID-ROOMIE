package com.wearerommies.roomie.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class SearchResultEntity(
    val x: Float = 126.9377f,
    val y: Float = 37.55438f,
    val location: String = "서울특별시 마포구 노고산동",
    val address: String = "",
    val roadAddress: String = ""
)
