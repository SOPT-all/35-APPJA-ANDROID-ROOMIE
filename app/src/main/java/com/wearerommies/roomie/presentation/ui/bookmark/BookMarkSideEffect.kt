package com.wearerommies.roomie.presentation.ui.bookmark

import androidx.annotation.StringRes

sealed class BookMarkSideEffect {
    data class ShowToast(val message: String) : BookMarkSideEffect()
    data class SnackBar(@StringRes val message: Int) : BookMarkSideEffect()
}