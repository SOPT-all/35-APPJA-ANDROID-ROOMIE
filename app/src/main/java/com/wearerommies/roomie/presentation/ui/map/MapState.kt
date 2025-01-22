package com.wearerommies.roomie.presentation.ui.map

import com.wearerommies.roomie.domain.entity.FilterResultEntity
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MapState(
    val latitude: Double = 37.563974138508,
    val longitude: Double = 126.93836946793,
    val isBottomSheetOpened: Boolean = true,
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
