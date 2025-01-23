package com.wearerommies.roomie.presentation.ui.tour.third

import com.wearerommies.roomie.domain.entity.TourEntity

data class TourThirdState(
    val uiState: TourEntity = TourEntity(),
    val isShowPreferredDateModal: Boolean = false
) {
    val isThirdEnabledButton = uiState.preferredDate.isNotEmpty()
}