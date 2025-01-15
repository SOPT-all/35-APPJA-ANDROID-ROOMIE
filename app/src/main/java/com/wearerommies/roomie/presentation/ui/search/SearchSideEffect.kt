package com.wearerommies.roomie.presentation.ui.search

sealed class SearchSideEffect {
    data class ShowToast(val message: String) : SearchSideEffect()
}
