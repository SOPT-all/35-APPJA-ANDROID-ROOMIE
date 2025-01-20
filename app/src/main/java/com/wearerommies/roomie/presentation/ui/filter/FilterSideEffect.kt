package com.wearerommies.roomie.presentation.ui.filter

sealed class FilterSideEffect {
    data class ShowToast(val message: String) : FilterSideEffect()
}
