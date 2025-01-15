package com.wearerommies.roomie.presentation.ui.filter.component

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
fun FilterChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = RoomieTheme.typography.body1R14,
        color = RoomieTheme.colors.grayScale11,
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 4.dp,
                backgroundColor = RoomieTheme.colors.grayScale1,
                borderColor = RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp
            )
            .padding(vertical = 6.dp, horizontal = 12.dp)
    )
}

@Preview
@Composable
fun FilterChipPreview() {
    RoomieAndroidTheme {
        FilterChip(
            text = "1인실"
        )
    }
}
