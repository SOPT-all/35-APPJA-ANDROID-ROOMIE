package com.wearerommies.roomie.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class FilterEntity(
    val location: String = "서울특별시 마포구 노고산동 11-1",
    val moodTag: String? = null,
    val depositRange: DepositRange = DepositRange(),
    val monthlyRentRange: MonthlyRentRange = MonthlyRentRange(),
    val genderPolicy: List<String> = listOf(),
    val preferredDate: String? = null,
    val occupancyTypes: List<String> = listOf(),
    val contractPeriod: List<Int> = listOf()
) {
    @Serializable
    data class DepositRange(
        val min: Int = 0,
        val max: Int = 500
    )

    @Serializable
    data class MonthlyRentRange(
        val min: Int = 0,
        val max: Int = 150
    )
}
