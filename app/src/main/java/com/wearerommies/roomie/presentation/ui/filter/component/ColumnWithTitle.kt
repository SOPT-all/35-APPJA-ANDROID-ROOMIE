package com.wearerommies.roomie.presentation.ui.filter.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun ColumnWithTitle(
    @StringRes title: Int,
    spacerValue: Dp,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(id = title),
            style = RoomieTheme.typography.body2Sb14,
            color = RoomieTheme.colors.grayScale12
        )

        Spacer(modifier = Modifier.height(spacerValue))

        content()
    }
}
