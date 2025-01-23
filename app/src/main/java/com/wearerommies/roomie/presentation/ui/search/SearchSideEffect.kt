package com.wearerommies.roomie.presentation.ui.search

import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.SearchResultEntity

sealed class SearchSideEffect {
    data class navigateToMap(
        val filter: FilterEntity,
        val result: SearchResultEntity
    ) : SearchSideEffect()
}
