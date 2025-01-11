package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.customShadow
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun SearchTextField(
    isReadOnly: Boolean,
    modifier: Modifier = Modifier,
    textFieldValue: String = "",
    onValueChange: (String) -> Unit = {}
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue(textFieldValue)) }
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    var isTrailingIconClicked by remember { mutableStateOf(false) }

    BasicTextField(
        value = textFieldState,
        onValueChange = { newValue ->
            textFieldState = newValue
            onValueChange(newValue.text)
        },
        textStyle = RoomieTheme.typography.title1R16.copy(RoomieTheme.colors.grayScale12),
        singleLine = true,
        readOnly = isReadOnly,
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                if (!isReadOnly) isFocused = focusState.isFocused
            }
            .then(
                if (isReadOnly) {
                    modifier.customShadow(shape = RoundedCornerShape(8.dp))
                } else {
                    modifier
                }
            )
            .then(
                if (isFocused) {
                    modifier.border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        color = RoomieTheme.colors.primary
                    )
                } else {
                    modifier
                }
            )
            .background(
                color = if (!isReadOnly) RoomieTheme.colors.grayScale2 else RoomieTheme.colors.grayScale1,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 5.dp)
            .padding(start = 14.dp, end = 6.dp),
        cursorBrush = SolidColor(RoomieTheme.colors.primary),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField()

                    if (textFieldState.text.isEmpty()) {
                        Text(
                            text = stringResource(R.string.search_textfield_placeholder),
                            color = RoomieTheme.colors.grayScale7,
                            style = RoomieTheme.typography.title1R16
                        )
                    }
                }

                Spacer(modifier = Modifier.width(4.dp))

                if (isTrailingIconClicked) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_delete_20px),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .noRippleClickable {
                                isTrailingIconClicked = false
                                textFieldState = TextFieldValue((""))
                            }
                    )
                } else {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search_24px),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .noRippleClickable {
                                if (textFieldState.text.isNotEmpty())
                                    isTrailingIconClicked = true
                            }
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SearchTextField(isReadOnly = true)

            SearchTextField(isReadOnly = false)
        }
    }
}
