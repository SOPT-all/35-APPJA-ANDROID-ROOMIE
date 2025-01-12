package com.wearerommies.roomie.presentation.type

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.ui.theme.GrayScale1
import com.wearerommies.roomie.ui.theme.GrayScale2

enum class SearchTextFieldType(
    val paddingTop: Dp,
    val paddingBottom: Dp,
    val paddingStart: Dp,
    val paddingEnd: Dp,
    val backgroundColor: Color,
    val isReadOnly: Boolean,
    val isShadowUsed: Boolean
) {
    MAP(
        paddingTop = 5.dp,
        paddingBottom = 5.dp,
        paddingStart = 14.dp,
        paddingEnd = 6.dp,
        backgroundColor = GrayScale1,
        isReadOnly = true,
        isShadowUsed = true
    ),
    SEARCH(
        paddingTop = 5.dp,
        paddingBottom = 5.dp,
        paddingStart = 15.dp,
        paddingEnd = 8.dp,
        backgroundColor = GrayScale2,
        isReadOnly = false,
        isShadowUsed = false
    )
}
