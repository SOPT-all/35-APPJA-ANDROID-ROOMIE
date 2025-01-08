package com.wearerommies.roomie.presentation.ui.mypage

import com.wearerommies.roomie.presentation.core.util.UiState

data class MyState(
    val uiState: UiState<String> = UiState.Loading
)
