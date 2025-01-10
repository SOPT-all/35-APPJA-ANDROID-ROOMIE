package com.wearerommies.roomie.presentation.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieTag(
    text: String,
    textStyle: TextStyle,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 8.dp))
            .noRippleClickable {
                onClick()
            }
            .padding(horizontal = 8.dp, vertical = 3.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Preview
@Composable
private fun RoomieTagPreview() {
    RoomieAndroidTheme {
        RoomieTag(
            text = "입주 완료",
            textStyle = RoomieTheme.typography.caption2Sb10.copy(
                color = RoomieTheme.colors.primary
            ),
            backgroundColor = RoomieTheme.colors.primaryLight4
        )
    }
}