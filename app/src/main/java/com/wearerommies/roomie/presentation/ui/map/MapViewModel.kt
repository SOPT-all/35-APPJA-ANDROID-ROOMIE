package com.wearerommies.roomie.presentation.ui.map

import androidx.lifecycle.ViewModel
import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.FilterResultEntity
import com.wearerommies.roomie.domain.repository.MapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val mapRepository: MapRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MapState())
    val state: StateFlow<MapState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<MapSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<MapSideEffect>
        get() = _sideEffect.asSharedFlow()

    val initialLatitude = 37.563974138508
    val initialLongitude = 126.93836946793

    fun fetchInitialLocation() {
        _state.value = _state.value.copy(
            latitude = initialLatitude,
            longitude = initialLongitude
        )
    }

    suspend fun fetchHouseList(filter: FilterEntity) {
        mapRepository.getFilterResult(filter)
            .onSuccess { resultList ->
                _state.value = _state.value.copy(
                    houseList =
                    resultList.map {
                        FilterResultEntity(
                            houseId = it.houseId,
                            x = it.x,
                            y = it.y,
                            monthlyRent = it.monthlyRent,
                            deposit = it.deposit,
                            occupancyTypes = it.occupancyTypes,
                            location = it.location,
                            genderPolicy = it.genderPolicy,
                            locationDescription = it.locationDescription,
                            isPinned = it.isPinned,
                            moodTag = it.moodTag,
                            contractTerm = it.contractTerm,
                            mainImgUrl = it.mainImgUrl
                        )
                    }.toPersistentList()
                )
            }.onFailure { error ->
                Timber.e(error)
            }
    }

    fun showMarkerDetail(id: Long) {
        val house = _state.value.houseList.find { it.houseId == id }

        if (house != null) {
            _state.value = _state.value.copy(
                markerDetail = house,
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
