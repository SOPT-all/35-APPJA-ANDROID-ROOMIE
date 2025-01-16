package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.BuildConfig
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.topBorder
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieFooter(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = RoomieTheme.typography.caption1R10,
    textColor: Color = RoomieTheme.colors.grayScale6,
    backgroundColor: Color = RoomieTheme.colors.grayScale1,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .topBorder(height = convertDpToFloat(1.dp), color = RoomieTheme.colors.grayScale5)
            .background(color = backgroundColor)
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.roomie_all_rights_reserved),
            style = textStyle,
            color = textColor,
        )

        Text(
            text = "Version ${BuildConfig.VERSION_NAME}",
            style = textStyle,
            color = textColor,
        )
    }
}

@Preview
@Composable
private fun RoomieFooterPreview() {
    RoomieAndroidTheme {
        RoomieFooter()
    }
}