package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieNavigateButton(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
    leadingIcon: @Composable () -> Unit = {},
    textStyle: TextStyle = RoomieTheme.typography.body2Sb14,
    textColor: Color = RoomieTheme.colors.grayScale12,
    arrowIconColor: Color = RoomieTheme.colors.grayScale10,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = backgroundColor,
                borderColor = borderColor,
                borderWidth = borderWidth
            )
            .clickable {
                onClick()
            }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leadingIcon()

        Text(
            text = text,
            style = textStyle,
            color = textColor,
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Icon(
            painter = painterResource(R.drawable.ic_arrow_right_line_black_24px),
            contentDescription = "이동",
            tint = arrowIconColor
        )
    }

}

@Preview
@Composable
private fun RoomieNavigateButtonPreview() {
    RoomieAndroidTheme {
        Column(
            modifier = Modifier.background(color = RoomieTheme.colors.primaryLight4),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            //내부 이미지 둘러보기
            RoomieNavigateButton(
                borderColor = RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp,
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(3.dp)
                            .padding(end = 8.dp),
                        painter = painterResource(R.drawable.ic_image_24px),
                        contentDescription = null,
                        tint = RoomieTheme.colors.grayScale6
                    )
                },
                text = "내부 이미지 둘러보기"
            )

            //지도에서 쉐어하우스 버튼 찾기
            RoomieNavigateButton(
                borderColor = RoomieTheme.colors.primaryLight2,
                borderWidth = 1.dp,
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 4.dp),
                        painter = painterResource(R.drawable.ic_map_line_black_16px),
                        contentDescription = null,
                        tint = RoomieTheme.colors.grayScale10
                    )
                },
                text = "지도에서 더 많은 쉐어하우스 찾기",
                modifier = Modifier
                    .padding(end = 8.dp)
            )
        }
    }
}