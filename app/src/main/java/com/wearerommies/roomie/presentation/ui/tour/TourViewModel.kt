package com.wearerommies.roomie.presentation.ui.tour

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
class TourViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(TourState())
    val state: StateFlow<TourState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun navigateSecondStep()  = viewModelScope.launch {
        _sideEffect.emit(TourSideEffect.NavigateToTwoStep)
    }

    suspend fun initState(houseId: Long, roomId: Long, houseName: String, roomName: String) {
        _state.value = _state.value.copy(
            TourEntity(
                houseId = houseId,
                roomId = roomId
            ),
            houseName = houseName,
            roomName = roomName
        )
    }

}