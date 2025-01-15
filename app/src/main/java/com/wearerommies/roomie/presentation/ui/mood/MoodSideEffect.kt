package com.wearerommies.roomie.presentation.ui.mood

sealed class MoodSideEffect {
    data class ShowToast(val message: String) : MoodSideEffect()
}