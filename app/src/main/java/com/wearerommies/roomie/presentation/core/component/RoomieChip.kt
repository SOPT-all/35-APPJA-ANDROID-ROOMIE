package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieTextChip(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = RoomieTheme.typography.body3M14,
    textColor: Color = RoomieTheme.colors.primary,
    backgroundColor: Color = RoomieTheme.colors.primaryLight4,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 4.dp))
            .noRippleClickable {
                onClick()
            }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}

@Composable
fun RoomieTextWithDotChip(
    firstText: String,
    secondText: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = RoomieTheme.typography.body4R12,
    contentColor: Color = RoomieTheme.colors.primary,
    backgroundColor: Color = RoomieTheme.colors.primaryLight4,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 4.dp))
            .noRippleClickable {
                onClick()
            }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                2.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            Text(
                text = firstText,
                style = textStyle,
                color = contentColor
            )
            Icon(
                painter = painterResource(R.drawable.ic_middle_dot),
                contentDescription = "dot",
                tint = contentColor
            )
            Text(
                text = secondText,
                style = textStyle,
                color = contentColor
            )
        }
    }
}

@Composable
fun RoomieOutlinedChip(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = RoomieTheme.typography.caption2Sb10,
    textColor: Color = RoomieTheme.colors.grayScale7,
    borderColor: Color = RoomieTheme.colors.grayScale5,
    backgroundColor: Color = RoomieTheme.colors.grayScale3,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .width((LocalConfiguration.current.screenWidthDp * 0.106).dp)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(size = 4.dp))
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 4.dp))
            .noRippleClickable {
                onClick()
            }
            .padding(horizontal = 6.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor
        )
    }
}

@Preview
@Composable
private fun RoomieKeywordPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            //map keyword
            RoomieTextChip(
                text = "#차분한",
                textStyle = RoomieTheme.typography.body4R12,
                textColor = RoomieTheme.colors.grayScale9,
                backgroundColor = Color(0xFFF3F1F1)
            )

            //detail keyword
            RoomieTextChip(
                text = "#차분한",
            )

            //detail keyword
            RoomieTextWithDotChip(
                firstText = "성별",
                secondText = "n인실",
            )

            //도로명&지번 키워드
            RoomieOutlinedChip(
                text = "도로명",
            )

            RoomieOutlinedChip(
                text = "지번",
            )
        }
    }
}