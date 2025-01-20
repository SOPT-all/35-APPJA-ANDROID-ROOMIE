package com.wearerommies.roomie.presentation.ui.bookmark

import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.util.UiState

data class BookMarkState(
    val uiState: UiState<List<RoomCardEntity>> = UiState.Loading
)