package com.wearerommies.roomie.presentation.ui.filter.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun FilterChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Text(
        text = text,
        style = if (isSelected) RoomieTheme.typography.body3M14 else RoomieTheme.typography.body1R14,
        color = if (isSelected) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale11,
        textAlign = TextAlign.Center,
        modifier = modifier
            .roundedBackgroundWithBorder(
                cornerRadius = 4.dp,
                backgroundColor = if (isSelected) RoomieTheme.colors.primaryLight5 else RoomieTheme.colors.grayScale1,
                borderColor = if (isSelected) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp
            )
            .padding(vertical = 6.dp, horizontal = 12.dp)
            .noRippleClickable { onClick() }
    )
}

@Preview
@Composable
fun FilterChipPreview() {
    RoomieAndroidTheme {
        FilterChip(
            text = stringResource(R.string.deposit),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun FilterChipSelectedPreview() {
    RoomieAndroidTheme {
        FilterChip(
            text = stringResource(R.string.apply),
            isSelected = true,
            onClick = {}
        )
    }
}
