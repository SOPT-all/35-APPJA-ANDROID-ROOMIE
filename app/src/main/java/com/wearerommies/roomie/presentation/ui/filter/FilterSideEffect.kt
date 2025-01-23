package com.wearerommies.roomie.presentation.ui.filter

import com.wearerommies.roomie.domain.entity.FilterEntity
import com.wearerommies.roomie.domain.entity.SearchResultEntity

sealed class FilterSideEffect {
    data class navigateToMap(
        val filter: FilterEntity,
        val searchResult: SearchResultEntity
    ) : FilterSideEffect()
}
