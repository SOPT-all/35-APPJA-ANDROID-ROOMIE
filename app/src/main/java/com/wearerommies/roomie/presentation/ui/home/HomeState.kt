package com.wearerommies.roomie.presentation.ui.home

import com.wearerommies.roomie.domain.entity.HomeDataEntity
import com.wearerommies.roomie.presentation.core.util.UiState

data class HomeState(
    val uiState: UiState<HomeDataEntity> = UiState.Loading
)