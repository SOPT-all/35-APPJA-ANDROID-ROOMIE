package com.wearerommies.roomie.domain.entity

data class FilterEntity(
    val location: String,
    val moodTag: String?,
    val depositRange: DepositRange,
    val monthlyRentRange: MonthlyRentRange,
    val genderPolicy: List<String>,
    val preferredDate: String?,
    val occupancyTypes: List<String>,
    val contractPeriod: List<Int>
){
    data class DepositRange(
        val min: Int,
        val max: Int
    )

    data class MonthlyRentRange(
        val min: Int,
        val max: Int
    )
}
