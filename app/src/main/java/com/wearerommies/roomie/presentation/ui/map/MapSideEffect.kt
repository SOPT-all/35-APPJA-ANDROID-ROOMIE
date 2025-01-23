package com.wearerommies.roomie.presentation.ui.map

sealed class MapSideEffect {
    data class ShowToast(val message: String) : MapSideEffect()
    data class NavigateToDetail(val houseId: Long) : MapSideEffect()
}
