package com.wearerommies.roomie.presentation.ui.home

import androidx.annotation.StringRes

sealed class HomeSideEffect {
    data class ShowToast(val message: String) : HomeSideEffect()
    data class SnackBar(@StringRes val message: Int) : HomeSideEffect()
}