package com.wearerommies.roomie.presentation.ui.map.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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

) {

    FilterButton(onClick = {})
}

@Composable
fun FilterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_map_fillter_20px),
        tint = Color.Unspecified,
        contentDescription = stringResource(R.string.navigate_to_filter),
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
        MapTopBar()
    }
}
