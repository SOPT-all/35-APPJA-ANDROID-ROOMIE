package com.wearerommies.roomie.presentation.type

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.GrayScale1
import com.wearerommies.roomie.ui.theme.GrayScale10
import com.wearerommies.roomie.ui.theme.GrayScale5
import com.wearerommies.roomie.ui.theme.GrayScale7
import com.wearerommies.roomie.ui.theme.PrimaryLight2
import com.wearerommies.roomie.ui.theme.PrimaryLight3
import com.wearerommies.roomie.ui.theme.RoomieTheme
import com.wearerommies.roomie.ui.theme.TransparentGray160

enum class NavigateButtonType(
    val paddingValues: PaddingValues,
    val backgroundColor: Color = GrayScale1,
    val borderColor: Color = Color.Transparent,
    val borderWidth: Dp = 0.dp,
    val leadingIcon: @Composable () -> Unit = {},
    val arrowIconColor: Color = GrayScale10,
) {
    HOME(
        paddingValues = PaddingValues(
            vertical = 12.dp,
            horizontal = 20.dp
        ),
        borderColor = PrimaryLight2,
        borderWidth = 1.dp,
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_map_line_black_16px),
                contentDescription = null,
                tint = RoomieTheme.colors.grayScale10
            )
        },
    ),
    UPDATE(
        paddingValues = PaddingValues(
            top = 12.dp,
            bottom = 12.dp,
            start = 16.dp,
            end = 24.dp
        ),
        backgroundColor = TransparentGray160,
        borderColor = PrimaryLight3,
        borderWidth = 1.dp,
    ),
    DETAIL(
        borderColor = GrayScale5,
        borderWidth = 1.dp,
        paddingValues = PaddingValues(
            all = 12.dp,
        ),
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp),
                imageVector = ImageVector.vectorResource(R.drawable.ic_image_24px),
                contentDescription = null,
                tint = RoomieTheme.colors.grayScale6
            )
        },
    ),
    MY(
        paddingValues = PaddingValues(
            vertical = 14.dp,
            horizontal = 20.dp,
        ),
        arrowIconColor = GrayScale7,
    )
}