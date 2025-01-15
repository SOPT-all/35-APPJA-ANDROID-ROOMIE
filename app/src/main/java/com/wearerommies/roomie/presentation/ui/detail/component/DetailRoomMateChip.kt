package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailRoomMateChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = RoomieTheme.typography.caption1R10,
        color = RoomieTheme.colors.grayScale8,
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 2.dp,
                backgroundColor = RoomieTheme.colors.grayScale4
            )
            .padding(horizontal = 4.dp, vertical = 2.dp)
    )
}

@Preview
@Composable
fun DetailRoomMateChipPreview() {
    RoomieAndroidTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            DetailRoomMateChip("ENFP")
            DetailRoomMateChip("룸A")
        }
    }
}