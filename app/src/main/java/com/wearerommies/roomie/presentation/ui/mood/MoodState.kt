package com.wearerommies.roomie.presentation.ui.mood

import com.wearerommies.roomie.presentation.core.util.UiState

data class MoodState(
    val uiState: UiState<String> = UiState.Loading
)