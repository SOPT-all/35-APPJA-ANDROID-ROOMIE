package com.wearerommies.roomie.presentation.ui.detail.house

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.entity.DetailHouseEntity
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.domain.usecase.GetDetailHouseUseCase
import com.wearerommies.roomie.presentation.core.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
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
class DetailHouseViewModel @Inject constructor(
    private val getDetailHouseUseCase: GetDetailHouseUseCase
): ViewModel() {

    private val _state = MutableStateFlow(DetailHouseState())
    val state: StateFlow<DetailHouseState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailHouseSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailHouseSideEffect>
        get() = _sideEffect.asSharedFlow()


    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(DetailHouseSideEffect.NavigateUp)
    }

    fun addRoom(roomId: Long) {
        _state.value = _state.value.copy(
            expandedRoomList = _state.value.expandedRoomList.add(roomId)
        )
    }

    fun removeRoom(roomId: Long) {
        _state.value = _state.value.copy(
            expandedRoomList = _state.value.expandedRoomList.remove(roomId)
        )
    }

    fun getDetailHouse(houseId: Long) = viewModelScope.launch {
        getDetailHouseUseCase(houseId).onSuccess { response ->
            _state.value = _state.value.copy(
                uiState = UiState.Success(response)
            )
        }.onFailure { error ->
            Timber.e(error)
        }
    }

}