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
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.presentation.type.NavigateButtonType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieNavigateButton(
    type: NavigateButtonType,
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = RoomieTheme.typography.body2Sb14,
    textColor: Color = RoomieTheme.colors.grayScale12,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = type.backgroundColor,
                borderColor = type.borderColor,
                borderWidth = type.borderWidth
            )
            .clickable {
                onClick()
            }
            .padding(
                type.paddingValues
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        type.leadingIcon()

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
            contentDescription = null,
            tint = type.arrowIconColor
        )
    }

}

@Preview
@Composable
private fun RoomieNavigateButtonPreview() {
    RoomieAndroidTheme {
        Column(
            modifier = Modifier
                .background(color = RoomieTheme.colors.primaryLight4)
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            //내부 이미지 둘러보기
            RoomieNavigateButton(
                type = NavigateButtonType.DETAIL,
                text = "내부 이미지 둘러보기"
            )

            //지도에서 쉐어하우스 버튼 찾기
            RoomieNavigateButton(
                type = NavigateButtonType.HOME,
                text = "지도에서 더 많은 쉐어하우스 찾기"
            )

            //찜 리스트
            RoomieNavigateButton(
                type = NavigateButtonType.MY,
                text = "찜 리스트"
            )
        }
    }
}