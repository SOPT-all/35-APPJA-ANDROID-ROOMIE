package com.wearerommies.roomie.presentation.ui.map

import androidx.annotation.StringRes

sealed class MapSideEffect {
    data class SnackBar(@StringRes val message: Int) : MapSideEffect()
    data class NavigateToDetail(val houseId: Long) : MapSideEffect()
}
