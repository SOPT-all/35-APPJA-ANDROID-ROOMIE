package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme

@Composable
fun ImageWithBackButton(
    imageUrl: String,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        RoomieTopBar(
            backgroundColor = Color.Transparent,
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .noRippleClickable {
                            onBackButtonClick()
                        },
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                    contentDescription = stringResource(R.string.back_button)
                )
            },
        )

        AsyncImage(
            model = imageUrl,
            contentDescription = stringResource(R.string.house_main_image),
            modifier = Modifier
                .height(272.dp)
        )
    }
}

@Composable
@Preview
fun ImageWithBackButtonPreview() {
    RoomieAndroidTheme {
        ImageWithBackButton(
            imageUrl = "",
            onBackButtonClick = {},
            modifier = Modifier
                .background(Color.Gray)
                .padding(top = 22.dp)
        )
    }
}