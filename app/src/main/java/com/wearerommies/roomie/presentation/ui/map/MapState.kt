package com.wearerommies.roomie.presentation.ui.map

import com.wearerommies.roomie.presentation.core.util.UiState

data class MapState(
    val uiState: UiState<String> = UiState.Loading
)
