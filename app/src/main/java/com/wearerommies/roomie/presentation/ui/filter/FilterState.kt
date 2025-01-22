package com.wearerommies.roomie.presentation.ui.filter

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class FilterState(
    val isDateModalOpened: Boolean = false,
    val location: String = "서울특별시 마포구 노고산동 11-1", // TODO: state 위치 고정??
    val moodTag: String? = null,
    val depositStart: Int = 0,
    val depositEnd: Int = 500,
    val monthlyRentStart: Int = 0,
    val monthlyRentEnd: Int = 150,
    val genderPolicy: PersistentList<String> = persistentListOf(),
    val preferredDate: String = "",
    val occupancyType: PersistentList<String> = persistentListOf(),
    val contractType: PersistentList<Int> = persistentListOf()
)
