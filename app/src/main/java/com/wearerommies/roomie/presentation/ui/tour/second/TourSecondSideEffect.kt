package com.wearerommies.roomie.presentation.ui.tour.second

import com.wearerommies.roomie.domain.entity.TourEntity

sealed class TourSecondSideEffect {
    data object NavigateUp: TourSecondSideEffect()
    data class NavigateToThirdStep(
        val tourApply: TourEntity
    ): TourSecondSideEffect()
}