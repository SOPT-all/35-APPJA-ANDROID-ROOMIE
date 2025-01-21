package com.wearerommies.roomie.presentation.ui.detail

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
class DetailViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailSideEffect>
        get() = _sideEffect.asSharedFlow()

    fun updateBottomSheetState() {
        _state.value = _state.value.copy(
            isShowBottomSheet = !_state.value.isShowBottomSheet
        )
    }

    fun updateLivingExpanded() {
        _state.value = _state.value.copy(
            isLivingExpanded = !_state.value.isLivingExpanded
        )
    }

    fun updatedKitchenExpanded() {
        _state.value = _state.value.copy(
            isKitchenExpanded = !_state.value.isKitchenExpanded
        )
    }
}