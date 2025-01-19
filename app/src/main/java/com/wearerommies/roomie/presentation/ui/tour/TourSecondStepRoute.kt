package com.wearerommies.roomie.presentation.ui.tour

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.presentation.core.component.RoomieDatePickerFieldWithTitle
import com.wearerommies.roomie.presentation.core.component.RoomieTextFieldWithTitle
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.type.DatePickerFieldType
import com.wearerommies.roomie.presentation.type.GenderType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun TourSecondStepRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: TourViewModel = hiltViewModel()
) {

}

@Composable
fun TourSecondStepScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateThirdStep: () -> Unit,
    onNameChanged: (String) -> Unit,
    onBirthdateChanged: (String) -> Unit,
    onClickGenderButton: (String) -> Unit,
    onPhoneNumberChanged: (String) -> Unit,
    state: TourState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(RoomieTheme.colors.grayScale1)
            .padding(paddingValues)
    ) {
        RoomieTopBar(
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .noRippleClickable(navigateUp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                    contentDescription = stringResource(R.string.move_back)
                )
            }
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.host_connect_title),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = stringResource(R.string.private_safety),
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale8,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
        )

        Spacer(Modifier.height(22.dp))

        RoomieTextFieldWithTitle(
            title = stringResource(R.string.name),
            paddingValues = PaddingValues(16.dp),
            textFieldValue = "", // state.name
            onValueChange = onNameChanged,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(28.dp))

        RoomieDatePickerFieldWithTitle(
            viewType = DatePickerFieldType.BIRTHDATE,
            dateValue = "", // state.birthdate
            onClick = {
                // ToDo: date picker 열기
                onBirthdateChanged("")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(28.dp))

        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            RoomieButton(
                text = stringResource(R.string.man),
                backgroundColor = RoomieTheme.colors.grayScale1,// if(state.gender == GenderType.MAN) RoomieTheme.colors.primaryLight5 else RoomieTheme.colors.grayScale1,
                textColor = RoomieTheme.colors.primary, // if(state.gender == GenderType.MAN) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale12,
                onClick = {
                    onClickGenderButton(GenderType.MAN.value)
                },
                modifier = Modifier
                    .weight(1f),
                borderColor = RoomieTheme.colors.primary, // if(state.gender == GenderType.MAN) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp,
                verticalPadding = 12.dp
            )

            RoomieButton(
                text = stringResource(R.string.woman),
                backgroundColor = RoomieTheme.colors.grayScale1,// if(state.gender == GenderType.WOMAN) RoomieTheme.colors.primaryLight5 else RoomieTheme.colors.grayScale1,
                textColor = RoomieTheme.colors.grayScale12, // if(state.gender == GenderType.WOMAN) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale12,
                onClick = {
                    onClickGenderButton(GenderType.WOMAN.value)
                },
                modifier = Modifier
                    .weight(1f),
                borderColor = RoomieTheme.colors.grayScale5, // if(state.gender == GenderType.MAN) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp,
                verticalPadding = 12.dp
            )
        }

        Spacer(Modifier.height(28.dp))

        // TODO: 유효성 검사 디바운스
        RoomieTextFieldWithTitle(
            title = stringResource(R.string.phone_number),
            paddingValues = PaddingValues(16.dp),
            textFieldValue = "", // state.phonenumber
            onValueChange = onPhoneNumberChanged,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            keyboardType = KeyboardType.Number,
            isValidated = true
        )

        Spacer(Modifier.weight(1f))

        RoomieButton(
            text = stringResource(R.string.next),
            backgroundColor = RoomieTheme.colors.primary,
            textColor = RoomieTheme.colors.grayScale1,
            onClick = navigateThirdStep,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
            isEnabled = true, // TODO: 버튼 활성화 상태 관리
            isPressed = true,
            pressedColor = RoomieTheme.colors.primaryLight1,
            enabledColor = RoomieTheme.colors.grayScale6
        )
    }
}

@Preview
@Composable
fun TourSecondStepScreenPreview() {
    RoomieAndroidTheme {
        TourSecondStepScreen(
            paddingValues = PaddingValues(0.dp),
            navigateUp = {},
            navigateThirdStep = {},
            onNameChanged = {},
            onBirthdateChanged = {},
            onClickGenderButton = {},
            onPhoneNumberChanged = {},
            state = TourState(
                houseName = "해피쉐어 루미 건대점",
                roomName = "1A(싱글배드)"
            )
        )
    }
}