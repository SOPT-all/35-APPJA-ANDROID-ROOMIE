package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieDatePickerFieldWithTitle(
    title: String,
    titleColor: Color,
    backgroundColor:Color,
    dateValue: String,
    onClick: () -> Unit, // TODO: date picker 열기
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            color = titleColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        RoomieDatePickerField(
            dateValue = dateValue,
            backgroundColor=backgroundColor,
            onClick = onClick
        )
    }
}

@Composable
fun RoomieDatePickerField(
    dateValue: String,
    backgroundColor:Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = RoomieTheme.colors.grayScale5
            )
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Text(
            text = dateValue.ifEmpty { stringResource(R.string.date_picker_place_holder) },
            color = if (dateValue.isEmpty()) RoomieTheme.colors.grayScale6 else RoomieTheme.colors.grayScale12,
            style = RoomieTheme.typography.body1R14,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_calender_24px),
            tint = Color.Unspecified,
            contentDescription = null,
            modifier = Modifier.noRippleClickable { onClick() }
        )
    }
}

@Preview
@Composable
fun RoomieDatePickerFieldPreview() {
    RoomieAndroidTheme {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            RoomieDatePickerFieldWithTitle(
                title = "제목",
                titleColor = RoomieTheme.colors.grayScale9,
                backgroundColor = RoomieTheme.colors.grayScale1,
                dateValue = "",
                onClick = {}
            )

            RoomieDatePickerFieldWithTitle(
                title = "제목",
                titleColor = RoomieTheme.colors.grayScale10,
                backgroundColor = RoomieTheme.colors.grayScale2,
                dateValue = "2025/01/02",
                onClick = {}
            )
        }
    }
}
