package com.wearerommies.roomie.presentation.ui.search

import com.wearerommies.roomie.domain.entity.FilterEntity

sealed class SearchSideEffect {
    data class navigateToMap(
        val filter: FilterEntity
    ) : SearchSideEffect()
}
