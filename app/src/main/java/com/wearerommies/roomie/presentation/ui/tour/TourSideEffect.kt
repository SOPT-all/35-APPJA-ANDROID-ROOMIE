package com.wearerommies.roomie.presentation.ui.tour

sealed class TourSideEffect {
    data object NavigateToTwoStep: TourSideEffect()
    data object NavigateUp: TourSideEffect()
    data object NavigateToSecondStep: TourSideEffect()
}