package com.wearerommies.roomie.presentation.ui.filter

import com.wearerommies.roomie.domain.entity.FilterEntity

sealed class FilterSideEffect {
    data class navigateToMap(
        val filter: FilterEntity
    ) : FilterSideEffect()
}
