package com.wearerommies.roomie.presentation.ui.tour.second

import android.util.Log
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
class TourSecondViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(TourSecondState())
    val state: StateFlow<TourSecondState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourSecondSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourSecondSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun initState(tourApply: TourEntity) {
        _state.value = _state.value.copy(
            uiState = tourApply
        )

    }

    fun updatedName(name: String) {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                name = name
            )
        )
    }

    fun updatedBirthdate(birthdate: Long?) {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                birthDate = birthdate?.let {
                    Date(birthdate).toFormattedString()
                }?:""
            )
        )
    }

    fun updatedGender(gender: String) {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                gender = gender
            )
        )
    }

    fun updatedPhoneNumber(phoneNumber: String) {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                phoneNumber = phoneNumber
            )
        )
    }

    fun navigateUp() = viewModelScope.launch {
        _sideEffect.emit(TourSecondSideEffect.NavigateUp)
    }

    fun navigateThirdStep() = viewModelScope.launch {
        _state.value = _state.value.copy(
            uiState = _state.value.uiState.copy(
                birthDate = _state.value.uiState.birthDate.toFormattedDto()
            )
        )
        _sideEffect.emit(
            TourSecondSideEffect.NavigateToThirdStep(
                tourApply = _state.value.uiState
            )
        )
    }

    fun updateBirthDateModalState() = viewModelScope.launch {
        _state.value = _state.value.copy(
            isShowBirthDateModal = !_state.value.isShowBirthDateModal
        )
    }
}