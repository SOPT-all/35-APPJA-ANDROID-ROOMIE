package com.wearerommies.roomie.presentation.ui.tour.first

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.TourEntity
import com.wearerommies.roomie.presentation.core.component.RoomieButton
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.ui.detail.component.DetailTextWithCheckIcon
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun TourFirstStepRoute(
    paddingValues: PaddingValues,
    tourApply: TourEntity,
    houseName: String,
    roomName: String,
    navigateUp: () -> Unit,
    navigateToTwoStep: (TourEntity) -> Unit,
    viewModel: TourFirstViewModel = hiltViewModel()
) {

    val counter by remember { mutableIntStateOf(0) }
    val currentCounter by rememberUpdatedState(counter)

    LaunchedEffect(currentCounter) {
        viewModel.initState(
            tourApply = tourApply,
            houseName = houseName,
            roomName = roomName
        )
    }

    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                TourFirstSideEffect.NavigateUp -> navigateUp()
                is TourFirstSideEffect.NavigateToSecondStep -> {
                    navigateToTwoStep(sideEffect.tourApply)
                }
            }
        }
    }

    TourFirstStepScreen(
        paddingValues = paddingValues,
        navigateUp = viewModel::navigateUp,
        navigateSecondStep = viewModel::navigateSecondStep,
        state = state
    )
}

@Composable
fun TourFirstStepScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateSecondStep: () -> Unit,
    state: TourFirstState,
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
            text = stringResource(R.string.room_correct_check),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale12,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                )
        )

        Spacer(Modifier.height(44.dp))

        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = stringResource(R.string.house_apply_location),
                style = RoomieTheme.typography.body2Sb14,
                color = RoomieTheme.colors.grayScale7,
            )

            Text(
                text = state.houseName,
                style = RoomieTheme.typography.body1R14,
                color = RoomieTheme.colors.grayScale12,
                overflow  = TextOverflow.Ellipsis
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(45.dp)
        ) {
            Text(
                text = stringResource(R.string.tour_target),
                style = RoomieTheme.typography.body2Sb14,
                color = RoomieTheme.colors.grayScale7,
            )

            DetailTextWithCheckIcon(
                text = state.roomName,
                modifier = Modifier
                    .fillMaxWidth()
            )

        }

        Spacer(Modifier.weight(1f))

        RoomieButton(
            text = stringResource(R.string.room_correct),
            backgroundColor = RoomieTheme.colors.primary,
            textColor = RoomieTheme.colors.grayScale1,
            onClick = navigateSecondStep,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            isPressed = true,
            pressedColor = RoomieTheme.colors.primaryLight1,
            enabledColor = RoomieTheme.colors.grayScale6
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TourFirstStepScreen(){
    RoomieAndroidTheme {
        TourFirstStepScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            navigateSecondStep = {},
            state = TourFirstState(
                houseName = "해피쉐어 루미 건대점",
                roomName = "1A(싱글배드)"
            )
        )
    }
}