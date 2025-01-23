package com.wearerommies.roomie.presentation.ui.tour.third

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.domain.repository.RoomRepository
import com.wearerommies.roomie.presentation.core.util.toFormattedDto
import com.wearerommies.roomie.presentation.core.util.toFormattedString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TourThirdViewModel @Inject constructor(
    val roomRepository: RoomRepository
): ViewModel() {

    private val _state = MutableStateFlow(TourThirdState())
    val state: StateFlow<TourThirdState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourThirdSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourThirdSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun initState(tourApply: TourEntity) {
        _state.value = _state.value.copy(
            uiState = tourApply
        )

    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(TourThirdSideEffect.NavigateUp)
    }


    fun updatePreferredDateModalState() = viewModelScope.launch {
        _state.value = _state.value.copy(
            isShowPreferredDateModal = !_state.value.isShowPreferredDateModal
        )
    }

    fun updateMessage(message: String?) = viewModelScope.launch {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                message = message
            )
        )
    }

    fun updatePreferredDate(preferredDate: Long?) {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                preferredDate = preferredDate?.let {
                    Date(preferredDate).toFormattedString()
                }?:""
            )
        )
    }

    fun applyRoomTour() = viewModelScope.launch {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                birthDate = _state.value.uiState.birthDate.toFormattedDto(),
                preferredDate = _state.value.uiState.preferredDate.toFormattedDto()
            )
        )
        roomRepository.applyRoomTour(_state.value.uiState)
            .onSuccess {
                _sideEffect.emit(TourThirdSideEffect.NavigateToCompletedStep)
            }.onFailure { error ->
                Timber.e(error)
            }
    }

}