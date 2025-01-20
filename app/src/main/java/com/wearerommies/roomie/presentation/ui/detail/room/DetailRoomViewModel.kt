package com.wearerommies.roomie.presentation.ui.detail.room

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailRoomViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(DetailRoomState())
    val state: StateFlow<DetailRoomState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailRoomSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailRoomSideEffect>
        get() = _sideEffect.asSharedFlow()

}