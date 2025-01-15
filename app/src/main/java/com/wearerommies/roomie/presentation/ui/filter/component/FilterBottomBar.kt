package com.wearerommies.roomie.presentation.ui.filter.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun FilterBottomBar(
    onClickResetButton: () -> Unit,
    onClickApplyButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        RoomieButton(
            text = stringResource(R.string.reset),
            backgroundColor = RoomieTheme.colors.grayScale1,
            textColor = RoomieTheme.colors.grayScale12,
            onClick = onClickResetButton, // TODO: 초기화 로직
            modifier = Modifier
                .weight(0.323f),
            borderColor = RoomieTheme.colors.grayScale5,
            borderWidth = 1.dp
        )

        Spacer(
            modifier = Modifier.weight(0.033f)
        )

        RoomieButton(
            text = stringResource(R.string.apply),
            backgroundColor = RoomieTheme.colors.primary,
            textColor = RoomieTheme.colors.grayScale1,
            onClick = onClickApplyButton, // TODO: 필터 적용
            modifier = Modifier
                .weight(0.556f),
            pressedColor = RoomieTheme.colors.primaryLight1,
            isPressed = true
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    RoomieAndroidTheme {
        FilterBottomBar(
            onClickResetButton = {},
            onClickApplyButton = {}
        )
    }
}
