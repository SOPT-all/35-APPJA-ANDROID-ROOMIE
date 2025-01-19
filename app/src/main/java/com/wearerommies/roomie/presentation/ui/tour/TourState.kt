package com.wearerommies.roomie.presentation.ui.tour

import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.presentation.core.util.UiState

data class TourState(
    //val uiState: TourEntity = TourEntity()
    val houseName: String,
    val roomName: List<String>
)