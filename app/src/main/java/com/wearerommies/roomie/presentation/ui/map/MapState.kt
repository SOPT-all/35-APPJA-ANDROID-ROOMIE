package com.wearerommies.roomie.presentation.ui.map

import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.FilterResultEntity
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MapState(
    val x: Float = 126.9377f,
    val y: Float = 37.55438f,
    val isBottomSheetOpened: Boolean = true,
    val filter: FilterEntity = FilterEntity(),
    val houseList: PersistentList<FilterResultEntity> = persistentListOf(),
    val markerDetail: FilterResultEntity = FilterResultEntity(
        x = 0F,
        y = 0F,
        houseId = 0,
        monthlyRent = "",
        deposit = "",
        contractTerm = 0,
        genderPolicy = "",
        occupancyTypes = "",
        location = "",
        locationDescription = "",
        moodTag = "",
        isPinned = false,
        mainImgUrl = ""
    ),
    val clickedMarkerId: Long? = null
)
