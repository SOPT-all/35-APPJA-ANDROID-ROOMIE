package com.wearerommies.roomie.presentation.ui.tour

sealed class TourSideEffect {
    data object NavigateUp: TourSideEffect()
    data object NavigateToSecondStep: TourSideEffect()
    data object NavigateToThirdStep: TourSideEffect()
    data object NavigateToCompletedStep: TourSideEffect()
}