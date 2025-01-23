package com.wearerommies.roomie.presentation.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.FilterResultEntity
import com.wearerommies.roomie.domain.entity.SearchResultEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.domain.repository.MapRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val mapRepository: MapRepository,
    private val houseRepository: HouseRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MapState())
    val state: StateFlow<MapState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<MapSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<MapSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun fetchInitialLocation(x: Float, y: Float) {
        _state.value = _state.value.copy(
            x = x,
            y = y,
        )
    }

    fun fetchFilterAndSearch(filter: FilterEntity, searchResult: SearchResultEntity) {
        _state.value = _state.value.copy(
            filter = _state.value.filter.copy(
                moodTag = filter.moodTag,
                depositRange = filter.depositRange,
                monthlyRentRange = filter.monthlyRentRange,
                genderPolicy = filter.genderPolicy,
                preferredDate = filter.preferredDate,
                occupancyTypes = filter.occupancyTypes,
                contractPeriod = filter.contractPeriod,
                location = searchResult.address.ifEmpty { filter.location }
            )
        )
    }

    suspend fun fetchHouseList() {
        mapRepository.getFilterResult(_state.value.filter)
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

    fun navigateToDetail(houseId: Long) = viewModelScope.launch {
        _sideEffect.emit(
            MapSideEffect.NavigateToDetail(
                houseId = houseId
            )
        )
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

    fun bookmarkHouse(houseId: Long) = viewModelScope.launch {
        houseRepository.bookmarkHouse(houseId = houseId)
            .onSuccess { response ->
                if (response.isPinned) {
                    _sideEffect.emit(
                        MapSideEffect.SnackBar(
                            message = R.string.add_to_bookmark_list
                        )
                    )
                }

                fetchHouseList()
            }.onFailure { error ->
                Timber.e(error)
            }
    }
}
