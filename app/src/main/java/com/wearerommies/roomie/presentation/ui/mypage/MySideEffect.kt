package com.wearerommies.roomie.presentation.ui.mypage

sealed class MySideEffect {
    data class ShowToast(val message: String) : MySideEffect()
}