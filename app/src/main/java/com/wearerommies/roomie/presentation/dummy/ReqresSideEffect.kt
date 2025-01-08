package com.wearerommies.roomie.presentation.reqres

sealed class ReqresSideEffect {
    data class ShowToast(val message: String) : ReqresSideEffect()
}
