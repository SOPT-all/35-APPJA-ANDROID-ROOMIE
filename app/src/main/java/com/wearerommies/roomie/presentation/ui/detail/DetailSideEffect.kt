package com.wearerommies.roomie.presentation.ui.detail

import com.wearerommies.roomie.domain.entity.TourEntity

sealed class DetailSideEffect {
    data object NavigateUp: DetailSideEffect()
    data class NavigateDetailRoom(
        val houseId: Long,
        val roomId: Long,
        val title: String
    ): DetailSideEffect()
    data class NavigateDetailHouse(
        val houseId: Long,
        val title: String
    ): DetailSideEffect()
    data class NavigateTourApply(
        val tourEntity: TourEntity,
        val houseName: String,
        val roomName: String
    ): DetailSideEffect()
}