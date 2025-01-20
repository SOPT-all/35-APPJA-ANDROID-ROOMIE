package com.wearerommies.roomie.presentation.ui.mypage

import com.wearerommies.roomie.domain.entity.MyPageEntity
import com.wearerommies.roomie.presentation.core.util.UiState

data class MyState(
    val uiState: UiState<MyPageEntity> = UiState.Loading
)
