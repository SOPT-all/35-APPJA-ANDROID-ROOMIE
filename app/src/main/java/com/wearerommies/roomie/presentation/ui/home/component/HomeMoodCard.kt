package com.wearerommies.roomie.presentation.ui.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun HomeMoodCard(
    moodTag: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .width((LocalConfiguration.current.screenWidthDp * 0.289).dp)
            .height((LocalConfiguration.current.screenHeightDp * 0.251).dp)
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = RoomieTheme.colors.primaryLight5,
                borderColor = RoomieTheme.colors.primaryLight3,
                borderWidth = 1.dp
            )
            .noRippleClickable {
                onClick()
            }
            .padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 10.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = moodTag,
                style = RoomieTheme.typography.body2Sb14,
                color = RoomieTheme.colors.primary,
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_line_black_16px),
                contentDescription = null,
                tint = RoomieTheme.colors.primary
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = "${moodTag} 분위기의\n방이 궁금하신가요?",
            style = RoomieTheme.typography.caption3M10,
            color = RoomieTheme.colors.primary,
        )
    }
}

@Preview
@Composable
private fun HomeMoodCardPreview() {
    RoomieAndroidTheme {
        HomeMoodCard(
            moodTag = "차분한"
        )
    }
}