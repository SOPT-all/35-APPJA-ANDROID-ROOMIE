package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieTextChip
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailRoomInfoStatusChip(
    status: Boolean,
    modifier: Modifier = Modifier
) {
    RoomieTextChip(
        text = if (status) stringResource(R.string.room_status_true) else stringResource(R.string.room_status_false),
        modifier = modifier,
        textStyle = RoomieTheme.typography.body4R12,
        textColor = if (status) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale9,
        backgroundColor = if (status) RoomieTheme.colors.primaryLight4 else RoomieTheme.colors.grayScale3
    )
}