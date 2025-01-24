package com.wearerommies.roomie.presentation.type

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.GrayScale1
import com.wearerommies.roomie.ui.theme.GrayScale10
import com.wearerommies.roomie.ui.theme.GrayScale12
import com.wearerommies.roomie.ui.theme.GrayScale2
import com.wearerommies.roomie.ui.theme.GrayScale9

enum class DatePickerFieldType(
    @StringRes val title: Int,
    val titleColor: Color,
    val backgroundColor: Color,
) {
    FILTER(
        title = R.string.desired_move_in_date,
        titleColor = GrayScale9,
        backgroundColor = GrayScale1
    ),
    TOUR(
        title = R.string.desired_move_in_date,
        titleColor = GrayScale12,
        backgroundColor = GrayScale2
    ),
    BIRTHDATE(
        title = R.string.birth_date,
        titleColor = GrayScale10,
        backgroundColor = GrayScale2
    )
}
