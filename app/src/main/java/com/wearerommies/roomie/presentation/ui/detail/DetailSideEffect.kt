package com.wearerommies.roomie.presentation.ui.detail

sealed class DetailSideEffect {
    data object NavigateUp: DetailSideEffect()
    data class NavigateDetailRoom(
        val houseId: Long,
        val roomId: Long,
        val title: String
    ): DetailSideEffect()
}