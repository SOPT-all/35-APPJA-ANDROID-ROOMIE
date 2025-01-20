package com.wearerommies.roomie.presentation.ui.detail.room

sealed class DetailRoomSideEffect {
    data object NavigateUp: DetailRoomSideEffect()
}