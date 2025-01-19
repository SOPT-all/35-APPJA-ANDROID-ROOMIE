package com.wearerommies.roomie.presentation.ui.filter.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun FilterTextField(
    paddingValues: PaddingValues,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    initValue: Int,
    maxValue: Int,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Number,
    textAlign: TextAlign = TextAlign.End,
    content: @Composable () -> Unit = {}
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Column {
        BasicTextField(
            value = textFieldValue,
            onValueChange = { newValue ->
                val newValueAsLong = newValue.toIntOrNull() ?: initValue
                if (newValueAsLong > maxValue) {
                    onValueChange(initValue.toString())
                } else {
                    onValueChange(newValue)
                }
            },
            textStyle = RoomieTheme.typography.title1R16.copy(
                color = RoomieTheme.colors.grayScale12,
                textAlign = textAlign,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .roundedBackgroundWithBorder(
                    cornerRadius = 8.dp,
                    backgroundColor = RoomieTheme.colors.grayScale2,
                    borderColor = when {
                        isFocused -> RoomieTheme.colors.primary
                        else -> RoomieTheme.colors.grayScale5
                    },
                    borderWidth = 1.dp
                )
                .padding(paddingValues),
            cursorBrush = SolidColor(RoomieTheme.colors.primary),
            decorationBox = { innerTextField ->
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        innerTextField()

                        if (textFieldValue.isEmpty()) {
                            Text(
                                text = initValue.toString(),
                                color = RoomieTheme.colors.grayScale7,
                                style = RoomieTheme.typography.title1R16,
                                textAlign = textAlign,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    if (content != {}) {
                        Spacer(modifier = Modifier.width(2.dp))

                        content()
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun RoomieTextFieldPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FilterTextField(
                paddingValues = PaddingValues(12.dp),
                textFieldValue = "",
                onValueChange = {},
                content = {
                    Text(
                        text = "만원",
                        style = RoomieTheme.typography.body3M14,
                        color = RoomieTheme.colors.grayScale10
                    )
                },
                initValue = 0,
                maxValue = 500
            )
        }
    }
}
