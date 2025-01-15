package com.wearerommies.roomie.presentation.ui.bookmark

sealed class BookMarkSideEffect {
    data class ShowToast(val message: String) : BookMarkSideEffect()
}