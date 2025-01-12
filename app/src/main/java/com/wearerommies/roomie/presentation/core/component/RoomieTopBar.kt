package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieTopBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    leadingIcon: @Composable () -> Unit = {},
    title: String? = null,
    titleStyle: TextStyle = RoomieTheme.typography.heading5Sb18,
    titleColor: Color = RoomieTheme.colors.grayScale12
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .height(48.dp)
            .padding(horizontal = 4.dp, vertical = 2.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            leadingIcon()
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title.orEmpty(),
                style = titleStyle,
                color = titleColor
            )
        }
    }
}

@Preview
@Composable
private fun RoomieTopBarPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            //백버튼, 타이틀 있음
            RoomieTopBar(
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                },
                title = "제목"
            )

            //백버튼 있음
            RoomieTopBar(
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                }
            )

            //배경 투명색
            RoomieTopBar(
                backgroundColor = Color.Transparent,
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                },
            )

            //타이틀 있음
            RoomieTopBar(
                title = "제목"
            )
        }
    }
}