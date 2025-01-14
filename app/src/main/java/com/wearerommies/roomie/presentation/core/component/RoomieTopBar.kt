package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieTopBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    leadingIcon: @Composable () -> Unit = {},
    title: String? = null,
    titleStyle: TextStyle = RoomieTheme.typography.heading5Sb18,
    titleColor: Color = RoomieTheme.colors.grayScale12,
    trailingIcon: @Composable () -> Unit = {},
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
                .fillMaxSize(),
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

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            trailingIcon()
        }
    }
}

@Preview
@Composable
private fun RoomieTopBarPreview() {
    RoomieAndroidTheme {
        Column(
            modifier = Modifier
                .background(color = RoomieTheme.colors.primaryLight3),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            //leading, title 있음
            RoomieTopBar(
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                },
                title = "제목"
            )

            //leading 있음
            RoomieTopBar(
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                }
            )

            //배경 투명색
            RoomieTopBar(
                backgroundColor = Color.Transparent,
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(all = 10.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                        contentDescription = "백버튼"
                    )
                },
            )

            //title 있음
            RoomieTopBar(
                title = "제목"
            )

            //leading, trailing 있음
            RoomieTopBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 3.dp),
                backgroundColor = Color.Transparent,
                leadingIcon = {
                    Row(
                        modifier = Modifier
                            .padding(all = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "연남동",
                            style = RoomieTheme.typography.title2Sb16,
                            color = RoomieTheme.colors.grayScale12
                        )
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_line_black_16px),
                            contentDescription = "백버튼"
                        )
                    }
                },
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .noRippleClickable {
                            }
                            .padding(all = 8.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_heart_line_black_24px),
                        contentDescription = null
                    )
                }
            )
        }
    }
}