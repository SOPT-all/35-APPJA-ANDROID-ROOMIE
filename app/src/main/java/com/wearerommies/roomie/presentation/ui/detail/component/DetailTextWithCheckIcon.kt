package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailTextWithCheckIcon(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_check_priamrycolor_20px),
            contentDescription = null,
            tint = RoomieTheme.colors.primary
        )

        Spacer(Modifier.width(4.dp))

        Text(
            text = text,
            style = RoomieTheme.typography.body1R14
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailTextWithCheckIconPreview() {
    RoomieAndroidTheme {
        DetailTextWithCheckIcon(
            text = "요리 후 바로 설거지해요"
        )
    }
}
