package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.presentation.type.DatePickerFieldType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieDatePickerFieldWithTitle(
    viewType: DatePickerFieldType,
    dateValue: String,
    onClick: () -> Unit, // TODO: date picker 열기
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(viewType.title),
            color = viewType.titleColor,
            style = RoomieTheme.typography.body2Sb14
        )

        Spacer(modifier = Modifier.height(12.dp))

        RoomieDatePickerField(
            dateValue = dateValue,
            backgroundColor = viewType.backgroundColor,
            onClick = onClick
        )
    }
}

@Composable
fun RoomieDatePickerField(
    dateValue: String,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = backgroundColor,
                borderColor = RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp
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
                viewType = DatePickerFieldType.FILTER,
                dateValue = "",
                onClick = {}
            )

            RoomieDatePickerFieldWithTitle(
                viewType = DatePickerFieldType.TOUR,
                dateValue = "2025/01/02",
                onClick = {}
            )
        }
    }
}
