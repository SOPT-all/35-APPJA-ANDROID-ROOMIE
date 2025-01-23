package com.wearerommies.roomie.presentation.ui.tour.completed

import com.wearerommies.roomie.presentation.type.MainTabType

sealed class TourCompletedSideEffect {
    data object NavigateUp: TourCompletedSideEffect()
    data object NavigateHome: TourCompletedSideEffect()
}