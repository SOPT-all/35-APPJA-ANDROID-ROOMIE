package com.wearerommies.roomie.presentation.ui.search

import com.wearerommies.roomie.domain.entity.SearchResultEntity
import com.wearerommies.roomie.presentation.core.util.EmptyUiState
import kotlinx.collections.immutable.PersistentList

data class SearchState(
    val uiState: EmptyUiState<PersistentList<SearchResultEntity>> = EmptyUiState.Loading,
    val searchKeyword: String = ""
)
