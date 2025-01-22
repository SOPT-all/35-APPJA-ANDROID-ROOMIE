package com.wearerommies.roomie.presentation.ui.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.ui.filter.component.FilterBottomBar
import com.wearerommies.roomie.presentation.ui.filter.component.FilterTab
import com.wearerommies.roomie.presentation.ui.filter.component.FilterTabRow
import com.wearerommies.roomie.presentation.ui.filter.screen.ContractTypeScreen
import com.wearerommies.roomie.presentation.ui.filter.screen.RentScreen
import com.wearerommies.roomie.presentation.ui.filter.screen.RoomTypeScreen
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun FilterRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToMap : () -> Unit,
    viewModel: FilterViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is FilterSideEffect.navigateToMap -> navigateToMap()
                }
            }
    }

    FilterScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        isDateModalOpened = state.isDateModalOpened,
        setDateModalVisible = viewModel::setDateModalVisible,
        monthlyRentStart = state.monthlyRentStart,
        monthlyRentEnd = state.monthlyRentEnd,
        depositStart = state.depositStart,
        depositEnd = state.depositEnd,
        genderPolicy = state.genderPolicy,
        preferredDate = state.preferredDate,
        occupancyType = state.occupancyType,
        contractPeriod = state.contractType,
        setDepositRangeStart = viewModel::setDepositRangeStart,
        setDepositRangeEnd = viewModel::setDepositRangeEnd,
        setMonthlyRangeStart = viewModel::setMonthlyRangeStart,
        setMonthlyRangeEnd = viewModel::setMonthlyRangeEnd,
        setGenderPolicy = viewModel::setGenderPolicy,
        setPreferredDate = viewModel::setPreferredDate,
        setOccupancyType = viewModel::setOccupancyType,
        setContractPeriod = viewModel::setContractPeriod,
        resetAll = viewModel::resetAll,
        applyCondition = viewModel::applyCondition
    )

}

@Composable
fun FilterScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    isDateModalOpened: Boolean,
    setDateModalVisible: () -> Unit,
    monthlyRentStart: Int,
    monthlyRentEnd: Int,
    depositStart: Int,
    depositEnd: Int,
    genderPolicy: PersistentList<String>,
    preferredDate: String,
    occupancyType: PersistentList<String>,
    contractPeriod: PersistentList<String>,
    setDepositRangeStart: (String) -> Unit,
    setDepositRangeEnd: (String) -> Unit,
    setMonthlyRangeStart: (String) -> Unit,
    setMonthlyRangeEnd: (String) -> Unit,
    setGenderPolicy: (PersistentList<String>) -> Unit,
    setPreferredDate: (Long?) -> Unit,
    setOccupancyType: (PersistentList<String>) -> Unit,
    setContractPeriod: (PersistentList<String>) -> Unit,
    resetAll: () -> Unit,
    applyCondition: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (selectedTabIndex, setSelectedTabIndex) = remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(RoomieTheme.colors.grayScale1)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        RoomieTopBar(
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                    tint = Color.Unspecified,
                    contentDescription = stringResource(R.string.move_back),
                    modifier = Modifier
                        .padding(10.dp)
                        .noRippleClickable(navigateUp)
                )
            },
            title = stringResource(R.string.filter)
        )
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val reservationMethods = persistentListOf(
                stringResource(R.string.price),
                stringResource(R.string.room_shape),
                stringResource(R.string.contract_period)
            )

            Column {
                Box {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(RoomieTheme.colors.grayScale5)
                            .align(Alignment.BottomCenter)
                    )

                    FilterTabRow(
                        selectedTabIndex = selectedTabIndex,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 27.dp),
                        contentColor = RoomieTheme.colors.grayScale12,
                        edgePadding = 0.dp
                    ) {
                        reservationMethods.forEachIndexed { index, type ->
                            FilterTab(
                                selected = selectedTabIndex == index,
                                onClick = { setSelectedTabIndex(index) },
                                modifier = Modifier
                                    .padding(top = 14.dp, bottom = 6.dp),
                            ) {
                                Text(
                                    text = type,
                                    style = if (selectedTabIndex == index) RoomieTheme.typography.body2Sb14 else RoomieTheme.typography.body1R14,
                                )
                            }
                        }
                    }
                }

                when (selectedTabIndex) {
                    0 -> RentScreen(
                        monthlyRentStart = monthlyRentStart,
                        monthlyRentEnd = monthlyRentEnd,
                        depositStart = depositStart,
                        depositEnd = depositEnd,
                        setMonthlyRangeStart = setMonthlyRangeStart,
                        setMonthlyRangeEnd = setMonthlyRangeEnd,
                        setDepositRangeStart = setDepositRangeStart,
                        setDepositRangeEnd = setDepositRangeEnd
                    )

                    1 -> RoomTypeScreen(
                        genderPolicy = genderPolicy,
                        occupancyType = occupancyType,
                        setGenderPolicy = setGenderPolicy,
                        setOccupancyType = setOccupancyType,
                    )

                    2 -> ContractTypeScreen(
                        isDateModalOpened = isDateModalOpened,
                        setDateModalVisible = setDateModalVisible,
                        preferredDate = preferredDate,
                        contractPeriod = contractPeriod,
                        setPreferredDate = setPreferredDate,
                        setContractPeriod = setContractPeriod
                    )
                }
            }

            FilterBottomBar(
                onClickResetButton = resetAll,
                onClickApplyButton = applyCondition,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


@Preview
@Composable
fun FilterScreenPreview() {
    RoomieAndroidTheme {
        FilterScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            isDateModalOpened = false,
            setDateModalVisible = {},
            monthlyRentStart = 0,
            monthlyRentEnd = 0,
            depositStart = 0,
            depositEnd = 0,
            genderPolicy = persistentListOf(),
            preferredDate = "",
            occupancyType = persistentListOf(),
            contractPeriod = persistentListOf(),
            setDepositRangeStart = {},
            setDepositRangeEnd = {},
            setMonthlyRangeStart = {},
            setMonthlyRangeEnd = {},
            setGenderPolicy = {},
            setPreferredDate = {},
            setOccupancyType = {},
            setContractPeriod = {},
            resetAll = {},
            applyCondition = {}
        )
    }
}
