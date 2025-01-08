package com.wearerommies.roomie.presentation.reqres

import com.wearerommies.roomie.presentation.core.util.UiState

data class ReqresState(
    // uiState 말고도 다양한 값들이 state 내부에 존재할 수 있어요! ex) 바텀시트의 open 여부
    val uiState: UiState<String> = UiState.Loading
)
