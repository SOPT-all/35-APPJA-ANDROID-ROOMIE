package com.wearerommies.roomie.presentation.ui.mypage

import com.wearerommies.roomie.domain.entity.MyPageEntity

data class MyState(
    val uiState: MyPageEntity = MyPageEntity(
        name = "닉네임"
    )
)
