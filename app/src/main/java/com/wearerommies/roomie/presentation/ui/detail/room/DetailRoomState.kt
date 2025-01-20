package com.wearerommies.roomie.presentation.ui.detail.room

import com.wearerommies.roomie.domain.entity.DetailRoomEntity
import com.wearerommies.roomie.presentation.core.util.UiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class DetailRoomState(
    val uiState: UiState<List<DetailRoomEntity>> = UiState.Loading,
    val expandedRoomList: PersistentList<Long> = persistentListOf()
)
