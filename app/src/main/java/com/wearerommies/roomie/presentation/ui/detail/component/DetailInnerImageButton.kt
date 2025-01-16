package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieNavigateButton
import com.wearerommies.roomie.presentation.type.NavigateButtonType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme

@Composable
fun DetailInnerImageButton(
    modifier: Modifier = Modifier
) {
    RoomieNavigateButton(
        type = NavigateButtonType.DETAIL,
        text = stringResource(R.string.inner_image_button_text),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DetailInnerImageButtonPreview() {
    RoomieAndroidTheme {
        DetailInnerImageButton(
            modifier = Modifier.padding(16.dp)
        )
    }
}