package com.wearerommies.roomie.presentation.ui.filter

sealed class FilterSideEffect {
    data object navigateToMap : FilterSideEffect()
}
