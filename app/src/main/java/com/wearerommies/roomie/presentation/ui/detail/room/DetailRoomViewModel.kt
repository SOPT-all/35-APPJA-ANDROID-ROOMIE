package com.wearerommies.roomie.presentation.ui.detail.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.repository.HouseRepository
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
class DetailRoomViewModel @Inject constructor(
    private val houseRepository: HouseRepository
): ViewModel() {
    private val _state = MutableStateFlow(DetailRoomState())
    val state: StateFlow<DetailRoomState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailRoomSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailRoomSideEffect>
        get() = _sideEffect.asSharedFlow()

    suspend fun getRoomDetail(houseId: Long) {
        houseRepository.getRoomDetail(houseId = houseId).onSuccess { response ->
            _state.value = _state.value.copy(
                uiState = UiState.Success(response)
            )
        }.onFailure { error ->
            Timber.e(error)
        }
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(DetailRoomSideEffect.NavigateUp)
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
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ///////////////////////////////////////////////////////////////////////////////////////