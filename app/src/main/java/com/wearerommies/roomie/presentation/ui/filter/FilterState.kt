package com.wearerommies.roomie.presentation.ui.filter

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class FilterState(
    val isDateModalOpened: Boolean = false,
    val location: String = "",
    val moodTag: String = "",
    val depositStart: Int = 0,
    val depositEnd: Int = 500,
    val monthlyRentStart: Int = 0,
    val monthlyRentEnd: Int = 150,
    val genderPolicy: PersistentList<String> = persistentListOf(),
    val preferredDate: String = "",
    val occupancyType: PersistentList<String> = persistentListOf(),
    val contractType: PersistentList<Int> = persistentListOf()
)
