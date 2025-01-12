package com.wearerommies.roomie.presentation.core.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) { onClick() }
}

fun Modifier.topBorder(
    height: Float,
    color: Color
) = this.drawWithContent {
    drawContent()
    drawLine(
        color = color,
        start = Offset(0f, 0f),
        end = Offset(size.width, 0f),
        strokeWidth = height,
    )
}

fun Modifier.roundedBackgroundWithBorder(
    cornerRadius: Dp,
    backgroundColor: Color,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
): Modifier {
    return this
        .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))
        .border(
            width = borderWidth,
            color = borderColor,
            shape = RoundedCornerShape(cornerRadius)
        )
}
