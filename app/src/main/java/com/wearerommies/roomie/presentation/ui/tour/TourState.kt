package com.wearerommies.roomie.presentation.ui.tour

import com.wearerommies.roomie.domain.entity.TourEntity

data class TourState(
    val uiState: TourEntity = TourEntity(),
    val houseName: String = "",
    val roomName: String = "",
    val isShowBirthDateModal: Boolean = false,
    val isShowPreferredDateModal: Boolean = false
) {
    val isSecondEnabledButton = uiState.name.isNotEmpty() && uiState.birthDate.isNotEmpty() && uiState.gender.isNotEmpty() && uiState.phoneNumber.isNotEmpty() && uiState.phoneNumber.length > 10
    val isThirdEnabledButton = uiState.preferredDate.isNotEmpty()
}