package com.wearerommies.roomie.presentation.ui.tour.first

import com.wearerommies.roomie.domain.entity.TourEntity

sealed class TourFirstSideEffect {
    data object NavigateUp: TourFirstSideEffect()
    data class NavigateToSecondStep(
        val tourApply: TourEntity
    ): TourFirstSideEffect()
}