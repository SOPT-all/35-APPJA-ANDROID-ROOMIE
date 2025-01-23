package com.wearerommies.roomie.presentation.ui.mood

import androidx.annotation.StringRes

sealed class MoodSideEffect {
    data class ShowToast(val message: String) : MoodSideEffect()
    data class SnackBar(@StringRes val message: Int) : MoodSideEffect()
    data class NavigateToDetail(val houseId: Long) : MoodSideEffect()
}