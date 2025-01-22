package com.wearerommies.roomie.presentation.ui.search

import com.wearerommies.roomie.domain.entity.SearchResultEntity
import com.wearerommies.roomie.presentation.core.util.EmptyUiState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class SearchState(
    val uiState: EmptyUiState<PersistentList<SearchResultEntity>> = EmptyUiState.Success(
        persistentListOf()
    ),
    val searchKeyword: String = "",
    val selectedX: Float = 0F,
    val selectedY: Float = 0F,
    val selectedAddress: String = ""
)
