package com.wearerommies.roomie.presentation.ui.tour.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.entity.TourEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TourFirstViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(TourFirstState())
    val state: StateFlow<TourFirstState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourFirstSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourFirstSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun initState(tourApply: TourEntity, houseName: String, roomName: String) {
        _state.value = _state.value.copy(
            uiState = tourApply,
            houseName = houseName,
            roomName = roomName
        )
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(TourFirstSideEffect.NavigateUp)
    }

    fun navigateSecondStep() = viewModelScope.launch {
        _sideEffect.emit(TourFirstSideEffect.NavigateToSecondStep(
            tourApply = _state.value.uiState
        ))
    }



}