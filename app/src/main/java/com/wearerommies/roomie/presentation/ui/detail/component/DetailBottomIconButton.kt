package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailBottomIconButton(
    icon: @Composable (isPinned: Boolean) -> Unit,
    onClickButton: () -> Unit = {},
    modifier: Modifier = Modifier,
    isPinned: Boolean = false
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = RoomieTheme.colors.grayScale1,
                borderColor = RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp
            )
            .clickable { onClickButton() }
            .padding(16.dp)
    ) {
        icon(isPinned)
    }
}

@Preview
@Composable
fun DetailBottomIconButtonPreview() {
    RoomieAndroidTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DetailBottomIconButton(
                icon = { isPinned ->
                    Icon(
                        imageVector = if (isPinned) ImageVector.vectorResource(R.drawable.ic_heart_24px_active) else ImageVector.vectorResource(
                            R.drawable.ic_heart_24px_active
                        ),
                        contentDescription = null,
                        tint = if (isPinned) RoomieTheme.colors.actionError else RoomieTheme.colors.grayScale6,
                    )
                },
                onClickButton = {}
            )
            DetailBottomIconButton(
                icon = { isPinned ->
                    Icon(
                        imageVector = if (isPinned) ImageVector.vectorResource(R.drawable.ic_heart_24px_active) else ImageVector.vectorResource(
                            R.drawable.ic_heart_24px_active
                        ),
                        contentDescription = null,
                        tint = if (isPinned) RoomieTheme.colors.actionError else RoomieTheme.colors.grayScale6
                    )
                },
                onClickButton = {},
                isPinned = true
            )
            DetailBottomIconButton(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_inquire_24px),
                        contentDescription = null,
                        tint = RoomieTheme.colors.grayScale6
                    )
                },
                onClickButton = {}
            )
        }
    }
}
