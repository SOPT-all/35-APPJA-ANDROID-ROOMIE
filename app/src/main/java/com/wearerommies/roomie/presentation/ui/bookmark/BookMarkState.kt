package com.wearerommies.roomie.presentation.ui.bookmark

import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.util.EmptyUiState

data class BookMarkState(
    val uiState: EmptyUiState<List<RoomCardEntity>> = EmptyUiState.Loading
)