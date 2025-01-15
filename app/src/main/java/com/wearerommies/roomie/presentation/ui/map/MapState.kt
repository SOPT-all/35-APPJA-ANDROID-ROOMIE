package com.wearerommies.roomie.presentation.ui.map

import com.wearerommies.roomie.domain.entity.HouseEntity
import com.wearerommies.roomie.presentation.ui.map.model.MarkerDetailModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MapState(
    val latitude: Double = 37.563974138508,
    val longitude: Double = 126.93836946793,
    val isBottomSheetOpened: Boolean = true,
    val houseList: PersistentList<HouseEntity> = persistentListOf(),
    val markerDetail: MarkerDetailModel = MarkerDetailModel(
        houseId = 0,
        monthlyRent = "",
        deposit = "",
        contractTerm = 0,
        gender = "",
        occupancy = "",
        location = "",
        locationDescription = "",
        moodTag = ""
    ),
    val clickedMarkerId: Int? = null
)
