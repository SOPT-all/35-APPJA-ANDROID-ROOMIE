package com.wearerommies.roomie.presentation.ui.detail.house

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
class DetailHouseViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow(DetailHouseState())
    val state: StateFlow<DetailHouseState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailHouseSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailHouseSideEffect>
        get() = _sideEffect.asSharedFlow()


}