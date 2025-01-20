package com.wearerommies.roomie.presentation.ui.map.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.clip
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
fun MapShadowTextField(
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isReadOnly: Boolean = true,
    content: @Composable () -> Unit = {}
) {
    var textFieldState by remember { mutableStateOf(TextFieldValue(textFieldValue)) }
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

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
            .customShadow(shape = RoundedCornerShape(8.dp))
            .background(
                color = RoomieTheme.colors.grayScale1,
                shape = RoundedCornerShape(8.dp)
            ),
        cursorBrush = SolidColor(RoomieTheme.colors.primary),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable(onClick = onClick)
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp,
                        start = 14.dp,
                        end = 6.dp
                    ),
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

                content()
            }
        }
    )
}

@Preview
@Composable
fun ShadowTextFieldPreview() {
    RoomieAndroidTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            MapShadowTextField(
                textFieldValue = "",
                onValueChange = {},
                onClick = {},
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search_24px),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .noRippleClickable { }
                    )
                }
            )

            MapShadowTextField(
                textFieldValue = "123456",
                onValueChange = {},
                onClick = {},
                content = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_search_24px),
                        tint = Color.Unspecified,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .noRippleClickable { }
                    )
                }
            )
        }
    }
}
