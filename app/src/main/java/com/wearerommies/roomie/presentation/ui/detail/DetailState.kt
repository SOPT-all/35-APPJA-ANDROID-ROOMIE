package com.wearerommies.roomie.presentation.ui.detail

import com.wearerommies.roomie.domain.entity.DetailEntity
import com.wearerommies.roomie.presentation.core.util.UiState

data class DetailState(
    val uiState: UiState<DetailEntity> = UiState.Loading,
    val isShowBottomSheet: Boolean = false,
    val isLivingExpanded: Boolean = false,
    val isKitchenExpanded: Boolean = false,
    val selectedTourRoom: Long = -1L,
    val selectedTourRoomName: String = "",
) {
    val isSelectedTourRoom: Boolean = (selectedTourRoom != -1L)
}
