package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.presentation.core.extension.topBorder
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailBottomBar(
    isPinned: Boolean,
    onClickPinButton: () -> Unit,
    onClickChatButton: () -> Unit,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .topBorder(convertDpToFloat(1.dp), RoomieTheme.colors.grayScale5)
            // TODO: 수현이가 만든 bottom border 추가하기
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DetailBottomIconButton(
            icon = { isPinned ->
                Icon(
                    imageVector = if (isPinned) ImageVector.vectorResource(R.drawable.ic_heart_24px_active) else ImageVector.vectorResource(R.drawable.ic_heart_24px_active),
                    contentDescription = stringResource(R.string.heart_button),
                    tint = if(isPinned) RoomieTheme.colors.actionError else RoomieTheme.colors.grayScale6
                )
            },
            onClickButton = onClickPinButton,
            isPinned = isPinned
        )
        DetailBottomIconButton(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_inquire_24px),
                    contentDescription = stringResource(R.string.chat_button),
                    tint = RoomieTheme.colors.grayScale6
                )
            },
            onClickButton = onClickChatButton
        )

        RoomieButton(
            text = "투어신청하기",
            backgroundColor = RoomieTheme.colors.primary,
            textColor = RoomieTheme.colors.grayScale1,
            onClick = {},
            modifier = Modifier
                .padding(end = 20.dp)
                .weight(1f)
                .fillMaxWidth(),
            pressedColor = RoomieTheme.colors.primaryLight1,
            isPressed = true
        )
    }
}

@Preview
@Composable
fun DetailBottomBarPreview() {
    RoomieAndroidTheme {
        DetailBottomBar(
            isPinned = true,
            onClickPinButton = {},
            onClickChatButton = {}
        )
    }
}