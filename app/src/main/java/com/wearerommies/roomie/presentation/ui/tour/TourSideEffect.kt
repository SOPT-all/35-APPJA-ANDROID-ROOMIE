package com.wearerommies.roomie.presentation.ui.tour

sealed class TourSideEffect {
    data class navigateTwoStep(val rooms: List<Int>): TourSideEffect()
    // data class navigationThreeStep()
}