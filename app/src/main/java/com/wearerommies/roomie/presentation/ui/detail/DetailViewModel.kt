package com.wearerommies.roomie.presentation.ui.detail

import androidx.lifecycle.ViewModel
import com.wearerommies.roomie.domain.repository.HouseRepository
import com.wearerommies.roomie.presentation.core.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val houseRepository: HouseRepository
): ViewModel() {
    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState>
        get() = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<DetailSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<DetailSideEffect>
        get() = _sideEffect.asSharedFlow()

    suspend fun getHouseDetail(houseId: Long) {
        houseRepository.getHouseDetail(houseId = houseId).onSuccess { response ->
                _state.value = _state.value.copy(
                    uiState = UiState.Success(response)
                )
            }.onFailure { error ->
                Timber.e(error)
            }
    }

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