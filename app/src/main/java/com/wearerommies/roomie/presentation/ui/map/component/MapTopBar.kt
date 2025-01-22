package com.wearerommies.roomie.presentation.ui.map.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.customShadow
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun MapTopBar(
    textfield: String,
    onClickSearchTextField: () -> Unit,
    onClickFilterButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MapShadowTextField(
            textFieldValue = textfield,
            onValueChange = {},
            onClick = onClickSearchTextField,
            content = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_search_24px),
                    tint = Color.Unspecified,
                    contentDescription = stringResource(R.string.search_button),
                    modifier = Modifier
                        .padding(8.dp)
                )
            },
            modifier = Modifier
                .weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        FilterButton(onClick = onClickFilterButton)
    }
}

@Composable
fun FilterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_map_fillter_20px),
        tint = Color.Unspecified,
        contentDescription = stringResource(R.string.filter_button),
        modifier = modifier
            .customShadow(shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background((RoomieTheme.colors.grayScale1))
            .padding(horizontal = 14.dp, vertical = 15.dp)
            .noRippleClickable { onClick() }
    )
}

@Preview
@Composable
fun MapTopBarPreview() {
    RoomieAndroidTheme {
        MapTopBar(
            textfield = "",
            onClickSearchTextField = {},
            onClickFilterButton = {}
        )
    }
}
