package com.wearerommies.roomie.presentation.ui.tour.second

import com.wearerommies.roomie.domain.entity.TourEntity

data class TourSecondState(
    val uiState: TourEntity = TourEntity(preferredDate = "123", message = "1232"),
    val houseName: String = "",
    val roomName: String = "",
    val isShowBirthDateModal: Boolean = false,
) {
    // TODO: 휴대전화번호 유효검사
    val isSecondEnabledButton = uiState.name.isNotEmpty() && uiState.birthDate.isNotEmpty() && uiState.gender.isNotEmpty() && uiState.phoneNumber.isNotEmpty() && uiState.phoneNumber.length > 10
}