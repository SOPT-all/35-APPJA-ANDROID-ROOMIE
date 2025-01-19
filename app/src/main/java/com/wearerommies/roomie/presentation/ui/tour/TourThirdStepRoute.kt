package com.wearerommies.roomie.presentation.ui.tour

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RommieTextField
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.presentation.core.component.RoomieDatePickerFieldWithTitle
import com.wearerommies.roomie.presentation.core.component.RoomieTextFieldWithTitle
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.type.DatePickerFieldType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun TourThirdStepRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: TourViewModel = hiltViewModel()
) {

}

@Composable
fun TourThirdStepScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateCompletedStep: () -> Unit,
    onPreferredDateChanged: (String) -> Unit,
    onClickGenderButton: (String) -> Unit,
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

        Spacer(Modifier.height(36.dp))

        Text(
            text = stringResource(R.string.preferred_date_message_title),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
        )

        Spacer(Modifier.height(44.dp))

        RoomieDatePickerFieldWithTitle(
            viewType = DatePickerFieldType.TOUR,
            dateValue = "", // state.perrferedDate
            onClick = {
                // ToDo: date picker 열기
                onPreferredDateChanged("")
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(32.dp))

        Text(
            text = stringResource(R.string.tour_message),
            style = RoomieTheme.typography.body2Sb14,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                )
        )

        Spacer(Modifier.height(8.dp))

        RommieTextField(
            paddingValues = PaddingValues(16.dp),
            placeHolder = stringResource(R.string.tour_message_placeholder),
            onValueChange = {},
            textFieldValue = "",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height((LocalConfiguration.current.screenHeightDp * 0.143).dp),
            singleLine = false
        )

        Spacer(Modifier.weight(1f))

        RoomieButton(
            text = stringResource(R.string.tour_apply_write_complete),
            backgroundColor = RoomieTheme.colors.primary,
            textColor = RoomieTheme.colors.grayScale1,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            isEnabled = true, // TODO: 버튼 활성화 상태 관리
            isPressed = true,
            pressedColor = RoomieTheme.colors.primaryLight1,
            enabledColor = RoomieTheme.colors.grayScale6
        )
    }
}

@Preview
@Composable
fun TourThirdStepScreenPreview() {
    RoomieAndroidTheme {
        TourThirdStepScreen(
            paddingValues = PaddingValues(0.dp),
            navigateUp = {},
            navigateCompletedStep = {},
            onPreferredDateChanged = {},
            onClickGenderButton = {},
            state = TourState(
                houseName = "해피쉐어 루미 건대점",
                roomName = "1A(싱글배드)"
            )
        )
    }
}