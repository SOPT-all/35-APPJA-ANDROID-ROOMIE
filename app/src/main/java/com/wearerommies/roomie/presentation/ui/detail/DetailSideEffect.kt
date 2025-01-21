package com.wearerommies.roomie.presentation.ui.detail

sealed class DetailSideEffect {
    data object NavigateUp: DetailSideEffect()
}