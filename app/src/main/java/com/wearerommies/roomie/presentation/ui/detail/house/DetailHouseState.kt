package com.wearerommies.roomie.presentation.ui.detail.Image

import com.wearerommies.roomie.domain.entity.DetailHouseEntity
import com.wearerommies.roomie.presentation.core.util.UiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class DetailHouseState(
    val uiState: UiState<DetailHouseEntity> = UiState.Loading,
    val expandedRoomList : PersistentList<Long> = persistentListOf(),
)
