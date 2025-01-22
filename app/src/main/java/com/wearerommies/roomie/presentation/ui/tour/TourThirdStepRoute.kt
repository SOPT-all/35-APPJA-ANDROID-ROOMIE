package com.wearerommies.roomie.presentation.ui.tour

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RommieTextField
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.presentation.core.component.RoomieDatePicker
import com.wearerommies.roomie.presentation.core.component.RoomieDatePickerFieldWithTitle
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.type.DatePickerFieldType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun TourThirdStepRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateCompletedStep: () -> Unit,
    viewModel: TourViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                TourSideEffect.NavigateUp -> navigateUp()
                TourSideEffect.NavigateToCompletedStep -> navigateCompletedStep()
                else -> return@collect
            }
        }
    }

    TourThirdStepScreen(
        paddingValues = paddingValues,
        navigateUp = viewModel::navigateUp,
        navigateCompletedStep = viewModel::navigateCompletedStep,
        onPreferredDateChanged = viewModel::updatePreferredDate,
        onMessageChanged = viewModel::updateMessage,
        updatePreferredDateModalState = viewModel::updatePreferredDateModalState,
        state = state
    )
}

@Composable
fun TourThirdStepScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateCompletedStep: () -> Unit,
    onPreferredDateChanged: (Long?) -> Unit,
    onMessageChanged: (String?) -> Unit,
    updatePreferredDateModalState: () -> Unit,
    state: TourState,
    modifier: Modifier = Modifier
) {

    if (state.isShowPreferredDateModal)
        RoomieDatePicker(
            onConfirm = { date ->
                onPreferredDateChanged(date)
                updatePreferredDateModalState()
            },
            onDismiss = {
                updatePreferredDateModalState()
            },
            modifier = Modifier.padding(horizontal = 36.dp)
        )

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
            dateValue = state.uiState.preferredDate,
            onClick = {
                updatePreferredDateModalState()
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
                    horizontal = 16.dp
                )
        )

        Spacer(Modifier.height(8.dp))

        RommieTextField(
            paddingValues = PaddingValues(16.dp),
            placeHolder = stringResource(R.string.tour_message_placeholder),
            onValueChange = onMessageChanged,
            textFieldValue = state.uiState.message ?: "",
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
            onClick = navigateCompletedStep,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            isEnabled = state.isThirdEnabledButton,
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
            state = TourState(
                houseName = "해피쉐어 루미 건대점",
                roomName = "1A(싱글배드)"
            ),
            onMessageChanged = {},
            updatePreferredDateModalState = {}
        )
    }
}