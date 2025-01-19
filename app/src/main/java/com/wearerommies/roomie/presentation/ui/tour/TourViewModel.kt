package com.wearerommies.roomie.presentation.ui.tour

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(

): ViewModel() {

//    private val _state = MutableStateFlow(TourState())
//    val state: StateFlow<TourState>
//        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<TourSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<TourSideEffect>
        get() = _sideEffect.asSharedFlow()


}