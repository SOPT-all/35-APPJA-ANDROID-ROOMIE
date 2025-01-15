package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieTextChip
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailRoomInfoStatusChip(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    RoomieTextChip(
        text = if (isAvailable) stringResource(R.string.room_status_true) else stringResource(R.string.room_status_false),
        modifier = modifier,
        textStyle = RoomieTheme.typography.body4R12,
        textColor = if (isAvailable) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale9,
        backgroundColor = if (isAvailable) RoomieTheme.colors.primaryLight4 else RoomieTheme.colors.grayScale3
    )
}

@Preview
@Composable
fun DetailRoomInfoStatusChipPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DetailRoomInfoStatusChip(
                isAvailable = true
            )

            DetailRoomInfoStatusChip(
                isAvailable = false
            )
        }
    }
}