package com.wearerommies.roomie.presentation.ui.tour

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.presentation.core.util.toFormattedString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(TourState())
    val state: StateFlow<TourState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun initState(houseId: Long, roomId: Long, houseName: String, roomName: String) {
        _state.value = _state.value.copy(
            uiState = TourEntity(
                houseId = houseId, roomId = roomId
            ),
            houseName = houseName,
            roomName = roomName
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
        _sideEffect.emit(TourSideEffect.NavigateUp)
    }

    fun navigateSecondStep() = viewModelScope.launch {
        _sideEffect.emit(TourSideEffect.NavigateToSecondStep)
    }

    fun navigateThirdStep() = viewModelScope.launch {
        _sideEffect.emit(TourSideEffect.NavigateToThirdStep)
    }

    fun updateDateModalState() = viewModelScope.launch {
        _state.value = _state.value.copy(
            isShowDateModal = !_state.value.isShowDateModal
        )
    }

}