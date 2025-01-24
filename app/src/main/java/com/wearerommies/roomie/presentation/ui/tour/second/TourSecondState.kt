package com.wearerommies.roomie.presentation.ui.tour.second

import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.presentation.core.util.RegexConstants.PHONE_NUMBER_REGEX

data class TourSecondState(
    val uiState: TourEntity = TourEntity(),
    val houseName: String = "",
    val roomName: String = "",
    val isShowBirthDateModal: Boolean = false,
    val isValidated: Boolean = true
) {
    val isSecondEnabledButton = uiState.name.isNotEmpty() && uiState.birthDate.isNotEmpty() && uiState.gender.isNotEmpty() && isValidated
}