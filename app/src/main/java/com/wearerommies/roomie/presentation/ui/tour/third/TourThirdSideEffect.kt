package com.wearerommies.roomie.presentation.ui.tour.third

sealed class TourThirdSideEffect {
    data object NavigateUp: TourThirdSideEffect()
    data object NavigateToCompletedStep: TourThirdSideEffect()
}