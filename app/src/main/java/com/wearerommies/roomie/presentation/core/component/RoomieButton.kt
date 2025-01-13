package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.presentation.core.extension.roomieButtonClickable
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieButton(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isPressed: Boolean = false,
    enabledColor: Color = Color.Transparent,
    pressedColor: Color = Color.Transparent,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
    horizontalPadding: Dp = 0.dp
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = RoomieTheme.typography.body2Sb14,
        color = textColor,
        modifier = modifier
            .let {
                if (isEnabled) {
                    it.roomieButtonClickable(
                        onClick = onClick,
                        pressedColor = pressedColor,
                        isPressed = isPressed
                    )
                } else {
                    it
                }
            }
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = if (isEnabled) backgroundColor else enabledColor,
                borderColor = borderColor,
                borderWidth = borderWidth
            )
            .padding(vertical = 18.dp, horizontal = horizontalPadding)
    )
}

@Preview(showBackground = true)
@Composable
fun RoomieButtonPreview() {
    RoomieAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                RoomieButton(
                    text = "찜",
                    backgroundColor = RoomieTheme.colors.grayScale4,
                    textColor = RoomieTheme.colors.grayScale12,
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(56.dp)
                )
                RoomieButton(
                    text = "챗",
                    backgroundColor = RoomieTheme.colors.grayScale4,
                    textColor = RoomieTheme.colors.grayScale12,
                    onClick = {},
                    modifier = Modifier
                        .size(56.dp)
                )
                RoomieButton(
                    text = "투어신청하기",
                    backgroundColor = RoomieTheme.colors.primary,
                    textColor = RoomieTheme.colors.grayScale1,
                    onClick = {},
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .weight(1f)
                        .fillMaxWidth(),
                    pressedColor = RoomieTheme.colors.primaryLight1,
                    isPressed = true
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                RoomieButton(
                    text = "초기화",
                    backgroundColor = RoomieTheme.colors.grayScale1,
                    textColor = RoomieTheme.colors.grayScale12,
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 20.dp),
                    borderColor = RoomieTheme.colors.grayScale5,
                    borderWidth = 1.dp,
                    horizontalPadding = 37.dp
                )
                RoomieButton(
                    text = "적용하기",
                    backgroundColor = RoomieTheme.colors.primary,
                    textColor = RoomieTheme.colors.grayScale1,
                    onClick = {},
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .fillMaxWidth(),
                    pressedColor = RoomieTheme.colors.primaryLight1,
                    isPressed = true,
                    horizontalPadding = 76.dp
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                RoomieButton(
                    text = "다른 방 보러가기",
                    backgroundColor = RoomieTheme.colors.grayScale1,
                    textColor = RoomieTheme.colors.grayScale8,
                    onClick = {},
                    modifier = Modifier
                        .padding(start = 20.dp),
                    borderColor = RoomieTheme.colors.grayScale6,
                    borderWidth = 1.dp,
                    horizontalPadding = 34.dp
                )
                RoomieButton(
                    text = "완료하기",
                    backgroundColor = RoomieTheme.colors.primary,
                    textColor = RoomieTheme.colors.grayScale1,
                    onClick = {},
                    modifier = Modifier
                        .padding(end = 20.dp),
                    horizontalPadding = 44.5.dp,
                    isPressed = true,
                    pressedColor = RoomieTheme.colors.primaryLight1
                )
            }

            RoomieButton(
                text = "다음으로",
                backgroundColor = RoomieTheme.colors.primary,
                textColor = RoomieTheme.colors.grayScale1,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                isPressed = true,
                pressedColor = RoomieTheme.colors.primaryLight1,
                enabledColor = RoomieTheme.colors.grayScale6
            )

            RoomieButton(
                text = "다음으로",
                backgroundColor = RoomieTheme.colors.primary,
                textColor = RoomieTheme.colors.grayScale1,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                isPressed = true,
                pressedColor = RoomieTheme.colors.primaryLight1,
                isEnabled = false,
                enabledColor = RoomieTheme.colors.grayScale6
            )
        }
    }
}