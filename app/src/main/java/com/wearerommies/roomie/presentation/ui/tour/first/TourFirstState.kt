package com.wearerommies.roomie.presentation.ui.tour.first

import com.wearerommies.roomie.domain.entity.TourEntity

data class TourFirstState(
    val uiState: TourEntity = TourEntity(),
    val houseName: String = "",
    val roomName: String = "",
    val isShowBirthDateModal: Boolean = false,
    val isShowPreferredDateModal: Boolean = false
)