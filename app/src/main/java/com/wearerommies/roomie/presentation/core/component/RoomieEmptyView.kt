package com.wearerommies.roomie.presentation.core.component

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
import com.wearerommies.roomie.presentation.type.EmptyViewType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieEmptyView(
    viewType: EmptyViewType,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_crying),
            contentDescription = null,
            modifier = Modifier
                .size((LocalConfiguration.current.screenWidthDp * 0.5).dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(viewType.title),
            color = RoomieTheme.colors.grayScale12,
            style = RoomieTheme.typography.title2Sb16,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(viewType.description),
            color = RoomieTheme.colors.grayScale7,
            style = RoomieTheme.typography.body4R12,
        )
    }
}

@Preview
@Composable
fun EmptyViewPreview() {
    RoomieAndroidTheme {
        RoomieEmptyView(viewType = EmptyViewType.LIST)
    }
}
