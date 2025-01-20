package com.wearerommies.roomie.presentation.ui.bookmark.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun BookmarkEmptyView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.img_sweating),
            contentDescription = null,
            modifier = Modifier
                .size((LocalConfiguration.current.screenWidthDp * 0.5).dp)
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )

        Text(
            text = stringResource(R.string.no_bookmark_property),
            color = RoomieTheme.colors.grayScale12,
            style = RoomieTheme.typography.heading5Sb18,
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        Text(
            text = stringResource(R.string.press_heart_to_bookmark_property),
            color = RoomieTheme.colors.grayScale12,
            style = RoomieTheme.typography.body1R14,
        )
    }
}

@Preview
@Composable
private fun BookmarkEmptyViewPreview() {
    RoomieAndroidTheme {
        BookmarkEmptyView()
    }
}