package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import java.util.Calendar
import java.util.TimeZone

const val UTC: String = "UTC"

@Composable
fun RoomieDatePicker(
    onConfirm: (selectedDateMillis: Long?) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    DatePickerModal(
        onConfirm = onConfirm,
        onDismiss = onDismiss,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onConfirm: (Long?) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val todayMillisUtc = Calendar.getInstance(TimeZone.getTimeZone(UTC)).apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = todayMillisUtc,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= todayMillisUtc
            }

            override fun isSelectableYear(year: Int): Boolean {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                return year >= currentYear
            }
        }
    )

    DatePickerDialog(
        modifier = Modifier.scale(.9f),
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(
                    text = stringResource(R.string.dismiss),
                    color = RoomieTheme.colors.grayScale11,
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(datePickerState.selectedDateMillis) }
            ) {
                Text(
                    text = stringResource(R.string.confirm),
                    color = RoomieTheme.colors.primary,
                )
            }
        },
        colors = DatePickerDefaults.colors(containerColor = RoomieTheme.colors.grayScale1),
    ) {
        DatePicker(
            state = datePickerState,
            showModeToggle = false,
            colors = DatePickerDefaults.colors(
                containerColor = RoomieTheme.colors.grayScale1,
                disabledSelectedDayContentColor = RoomieTheme.colors.grayScale5,
                selectedDayContainerColor = RoomieTheme.colors.primary,
                selectedDayContentColor = RoomieTheme.colors.grayScale1,
                todayContentColor = RoomieTheme.colors.primary,
                todayDateBorderColor = RoomieTheme.colors.primary,
            )
        )
    }
}

@Preview
@Composable
fun RoomieDatePickerPreview() {
    RoomieAndroidTheme {
        RoomieDatePicker(
            onConfirm = {},
            onDismiss = {},
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}
