package com.wearerommies.roomie.presentation.ui.mood

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.component.RoomieFooter
import com.wearerommies.roomie.presentation.core.component.RoomieRoomCard
import com.wearerommies.roomie.presentation.core.component.RoomieSnackbar
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.bottomBorder
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun MoodRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: MoodViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackBarHost = remember { SnackbarHostState() }
    val counter by remember { mutableIntStateOf(0) }

    val currentCounter by rememberUpdatedState(counter)

    LaunchedEffect(currentCounter) {
        viewModel.getMoodList()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MoodSideEffect.ShowToast -> context.showToast(message = sideEffect.message)
                    is MoodSideEffect.SnackBar -> {
                        snackBarHost.currentSnackbarData?.dismiss()
                        snackBarHost.showSnackbar(
                            message = context.getString(sideEffect.message),
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
    }

    MoodScreen(
        paddingValues = paddingValues,
        snackBarHost = snackBarHost,
        navigateUp = navigateUp,
        onLikeClick = viewModel::patchHousePin,
        state = state.uiState
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoodScreen(
    paddingValues: PaddingValues,
    snackBarHost: SnackbarHostState,
    navigateUp: () -> Unit,
    onLikeClick: () -> Unit,
    state: UiState<String>,
    modifier: Modifier = Modifier
) {
    val screenWeigth = LocalConfiguration.current.screenWidthDp
    val height = (screenWeigth * 0.5).dp

    Popup(
        alignment = Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackBarHost) { snackbarData ->
            RoomieSnackbar(
                modifier = Modifier
                    .padding(
                        bottom = 23.dp,
                        start = 12.dp,
                        end = 12.dp
                    ),
                message = snackbarData.visuals.message
            )
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = RoomieTheme.colors.grayScale1)
            .padding(paddingValues),
    ) {
        when (state) {
            is UiState.Loading -> {
                item {
                    //todo: 로딩뷰
                    Text(
                        modifier = Modifier
                            .noRippleClickable { navigateUp() },
                        text = "LOADING",
                        color = RoomieTheme.colors.primaryLight1,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Failure -> {
                item {
                    Text(
                        modifier = Modifier
                            .noRippleClickable { navigateUp() },
                        text = "데이터 불러오기 실패",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Success -> {
                stickyHeader {
                    RoomieTopBar(
                        modifier = Modifier
                            .bottomBorder(
                                height = convertDpToFloat(1.dp),
                                color = RoomieTheme.colors.grayScale4
                            ),
                        leadingIcon = {
                            Icon(
                                modifier = Modifier
                                    .noRippleClickable { navigateUp() }
                                    .padding(all = 10.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_left_line_black_24px),
                                contentDescription = stringResource(R.string.move_back)
                            )
                        },
                        title = "#차분한" //todo: 더미
                    )
                }

                item {
                    Column(
                        modifier = Modifier
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        RoomieTheme.colors.primary.copy(alpha = 0.2f),
                                        RoomieTheme.colors.grayScale1,
                                    )
                                ),
                                shape = RectangleShape,
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 10.dp, bottom = 25.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(160.dp)
                                    .padding(end = 10.dp)
                                    .align(Alignment.CenterEnd),
                                painter = painterResource(R.drawable.img_moodview_calm),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )

                            MoodHeaderMessage(
                                modifier = Modifier
                                    .padding(
                                        start = 20.dp
                                    )
                                    .align(Alignment.CenterStart),
                                mood = "#차분한"
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )
                    }
                }

                items(count = 3, key = { it }) {
                    RoomieRoomCard(
                        modifier = Modifier
                            .padding(start = 12.dp, end = 12.dp, bottom = 4.dp),
                        roomCardEntity = RoomCardEntity(
                            houseId = 1,
                            monthlyRent = "30~50",
                            deposit = "200~300",
                            occupancyType = "2인실",
                            location = "서대문구 연희동",
                            genderPolicy = "여성전용",
                            locationDescription = "자이아파트",
                            isPinned = true,
                            contractTerm = 6,
                            mainImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg"
                        ),
                        onClick = { },
                        onLikeClick = onLikeClick
                    )
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )

                    RoomieFooter()
                }
            }
        }
    }
}

@Composable
private fun MoodHeaderMessage(
    mood: String,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = mood,
                style = RoomieTheme.typography.heading5Sb18,
                color = RoomieTheme.colors.primary
            )

            Text(
                text = stringResource(R.string.find_house),
                style = RoomieTheme.typography.heading5Sb18,
                color = RoomieTheme.colors.grayScale12
            )
        }

        Text(
            modifier = modifier,
            text = stringResource(R.string.recommend_house),
            style = RoomieTheme.typography.heading5Sb18,
            color = RoomieTheme.colors.grayScale12
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )

        Text(
            modifier = modifier
                .padding(bottom = 8.dp),
            text = stringResource(R.string.mood_house_list),
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale8
        )
    }
}

@Preview
@Composable
fun MoodScreenPreview() {
    RoomieAndroidTheme {
        MoodScreen(
            paddingValues = PaddingValues(),
            snackBarHost = remember { SnackbarHostState() },
            navigateUp = {},
            onLikeClick = {},
            state = UiState.Success("")
        )
    }
}