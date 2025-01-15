package com.wearerommies.roomie.presentation.ui.map

import androidx.lifecycle.ViewModel
import com.wearerommies.roomie.domain.entity.HouseEntity
import com.wearerommies.roomie.presentation.ui.map.model.toMarkerDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
) : ViewModel() {
    private val _state = MutableStateFlow(MapState())
    val state: StateFlow<MapState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<MapSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<MapSideEffect>
        get() = _sideEffect.asSharedFlow()

    val initialLatitude = 37.563974138508
    val initialLongitude = 126.93836946793

    val houseList = listOf(
        HouseEntity(
            houseId = 1,
            x = 37.561231,
            y = 126.946854,
            monthlyRent = "30~50",
            deposit = "200~300",
            occupancyTypes = "1,2인실",
            location = "서대문구 연희동",
            genderPolicy = "여성전용",
            locationDescription = "자이아파트",
            isPinned = true,
            moodTag = "#차분한",
            contractTerm = 6,
            mainImgUrl = "https://example.com/images/house1.jpg"
        ),
        HouseEntity(
            houseId = 2,
            x = 37.563231,
            y = 126.943854,
            monthlyRent = "30~50",
            deposit = "200~300",
            occupancyTypes = "1,2인실",
            location = "서대문구 연희동",
            genderPolicy = "여성전용",
            locationDescription = "자이아파트",
            isPinned = true,
            moodTag = "#차분한",
            contractTerm = 6,
            mainImgUrl = "https://example.com/images/house1.jpg"
        ),
        HouseEntity(
            houseId = 3,
            x = 37.565231,
            y = 126.948854,
            monthlyRent = "30~50",
            deposit = "200~300",
            occupancyTypes = "1,2,3인실",
            location = "서대문구 연희동",
            genderPolicy = "여성전용",
            locationDescription = "자이아파트",
            isPinned = true,
            moodTag = "#차분한",
            contractTerm = 6,
            mainImgUrl = "https://example.com/images/house1.jpg"
        ),
        HouseEntity(
            houseId = 4,
            x = 37.561231,
            y = 126.946854,
            monthlyRent = "30~50",
            deposit = "200~300",
            occupancyTypes = "1,2,3,4,5인실",
            location = "서대문구 연희동",
            genderPolicy = "여성전용",
            locationDescription = "자이아파트",
            isPinned = true,
            moodTag = "#차분한",
            contractTerm = 6,
            mainImgUrl = "https://example.com/images/house1.jpg"
        ),
    )

    fun fetchInitialLocation() {
        _state.value = _state.value.copy(
            latitude = initialLatitude,
            longitude = initialLongitude
        )
    }

    fun fetchHouseList() {
        _state.value = _state.value.copy(
            houseList = houseList.toPersistentList()
        )
    }

    fun showMarkerDetail(id: Int) {
        val house = _state.value.houseList.find { it.houseId == id }

        if (house != null) {
            _state.value = _state.value.copy(
                markerDetail = house.toMarkerDetailModel(),
                clickedMarkerId = id
            )
        }
    }

    fun resetClickedMarker() {
        _state.value = _state.value.copy(
            clickedMarkerId = null
        )
    }

    fun setBottomSheetState(state: Boolean) {
        _state.value = _state.value.copy(
            isBottomSheetOpened = state
        )
    }
}
