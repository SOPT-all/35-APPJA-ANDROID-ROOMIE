package com.wearerommies.roomie.presentation.ui.tour

sealed class TourSideEffect {
    data class navigationTwoStep(val rooms: List<Int>): TourSideEffect()
    // data class navigationThreeStep()
}