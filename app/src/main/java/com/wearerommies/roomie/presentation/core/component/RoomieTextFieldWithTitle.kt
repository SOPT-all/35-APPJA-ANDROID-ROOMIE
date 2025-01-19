package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieTextFieldWithTitle(
    title: String,
    paddingValues: PaddingValues,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    color: Color,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    isValidated: Boolean = true,
    placeHolder: String = ""
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = RoomieTheme.typography.body2Sb14,
            color = color
        )

        Spacer(Modifier.height(8.dp))

        RommieTextField(
            paddingValues = paddingValues,
            textFieldValue = textFieldValue,
            onValueChange = onValueChange,
            keyboardType = keyboardType,
            isValidate = isValidated,
            placeHolder = placeHolder
        )
    }
}

@Preview
@Composable
fun RoomieTextFieldWithTitlePreview() {
    RoomieAndroidTheme {
        RoomieTextFieldWithTitle(
            title = "title",
            paddingValues = PaddingValues(12.dp),
            textFieldValue = "",
            onValueChange = {},
            color = RoomieTheme.colors.grayScale12
        )
    }
}
