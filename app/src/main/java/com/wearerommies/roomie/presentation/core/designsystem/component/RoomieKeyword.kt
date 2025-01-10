package com.wearerommies.roomie.presentation.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun RoomieTextKeyword(
    text: String,
    textStyle: TextStyle,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 4.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
fun RoomieKeyword(
    content: @Composable () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(size = 4.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Preview
@Composable
fun RoomieKeywordPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            //map keyword
            RoomieTextKeyword(
                text = "#차분한",
                textStyle = RoomieTheme.typography.body4R12.copy(
                    color = RoomieTheme.colors.grayScale9
                ),
                backgroundColor = Color(0xFFF3F1F1)
            )

            //detail keyword
            RoomieTextKeyword(
                text = "#차분한",
                textStyle = RoomieTheme.typography.body3M14.copy(
                    color = RoomieTheme.colors.primary
                ),
                backgroundColor = RoomieTheme.colors.primaryLight4
            )

            //detail keyword
            RoomieKeyword(
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            2.dp,
                            alignment = Alignment.CenterHorizontally
                        )
                    ) {
                        Text(
                            text = "성별",
                            style = RoomieTheme.typography.body4R12.copy(
                                color = RoomieTheme.colors.primary
                            ),
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_middle_dot),
                            contentDescription = "dot"
                        )
                        Text(
                            text = "n인실",
                            style = RoomieTheme.typography.body4R12.copy(
                                color = RoomieTheme.colors.primary
                            ),
                        )
                    }
                },
                backgroundColor = RoomieTheme.colors.primaryLight4
            )
        }
    }
}