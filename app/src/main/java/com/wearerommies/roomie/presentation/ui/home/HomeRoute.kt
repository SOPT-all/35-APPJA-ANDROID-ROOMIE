package com.wearerommies.roomie.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import coil.compose.AsyncImage
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.component.RoomieNavigateButton
import com.wearerommies.roomie.presentation.core.component.RoomieRoomCard
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.bottomBorder
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.presentation.type.HomeMoodCardType
import com.wearerommies.roomie.presentation.type.NavigateButtonType
import com.wearerommies.roomie.presentation.ui.home.component.HomeMoodCard
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is HomeSideEffect.ShowToast -> context.showToast(message = sideEffect.message)
                }
            }
    }

    HomeScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state.uiState
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<String>,
    modifier: Modifier = Modifier
) {
    val screenWeight = LocalConfiguration.current.screenWidthDp
    val height = (screenWeight * 0.5).dp

    val scrollState = rememberLazyListState()
    val scrollOffset = scrollState.firstVisibleItemScrollOffset
    val topBarBackgroundColor = if (scrollOffset > 1) Color.White else Color.Transparent
    val topBarBorderColor =
        if (scrollOffset > 1) RoomieTheme.colors.grayScale4 else Color.Transparent

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        RoomieTheme.colors.primary
                    )
                ),
                shape = RectangleShape
            )
            .padding(paddingValues),
    ) {
        when (state) {
            is UiState.Loading -> {
                stickyHeader {
                    RoomieTopBar(
                        modifier = Modifier
                            .background(color = topBarBackgroundColor)
                            .bottomBorder(
                                color = topBarBorderColor,
                                height = convertDpToFloat(1.dp)
                            )
                            .padding(horizontal = 20.dp, vertical = 4.dp),
                        backgroundColor = topBarBackgroundColor,
                        leadingIcon = {
                            Row(
                                modifier = Modifier
                                    .padding(all = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(R.string.home_location),
                                    style = RoomieTheme.typography.title2Sb16,
                                    color = RoomieTheme.colors.grayScale12
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_line_black_16px),
                                    contentDescription = stringResource(R.string.back)
                                )
                            }
                        },
                        trailingIcon = {
                            Icon(
                                modifier = Modifier
                                    .noRippleClickable {
                                        //todo: 찜 리스트로 넘어가기
                                    }
                                    .padding(all = 8.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.ic_heart_line_black_24px),
                                contentDescription = stringResource(R.string.navigate_to_bookmark)
                            )
                        }
                    )
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )

                    HomeGreetingMessage(
                        modifier = Modifier.padding(
                            start = 20.dp
                        ),
                        nickname = stringResource(R.string.user_nickname)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(66.dp)
                    )

                    RoomieNavigateButton(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        type = NavigateButtonType.UPDATE,
                        text = stringResource(R.string.today_find_out_update),
                        textStyle = RoomieTheme.typography.body3M14,
                        textColor = RoomieTheme.colors.grayScale10
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Color.White, shape = RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp
                                )
                            )
                            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    ) {
                        Column {
                            Text(
                                text = stringResource(R.string.find_mood),
                                style = RoomieTheme.typography.heading5Sb18,
                                color = RoomieTheme.colors.grayScale12
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                HomeMoodCard(
                                    modifier = Modifier.weight(1f),
                                    homeMoodCardType = HomeMoodCardType.CALM,
                                    onClick = {}
                                )

                                HomeMoodCard(
                                    modifier = Modifier.weight(1f),
                                    homeMoodCardType = HomeMoodCardType.ACTIVE,
                                    onClick = {}
                                )

                                HomeMoodCard(
                                    modifier = Modifier.weight(1f),
                                    homeMoodCardType = HomeMoodCardType.CLEAN,
                                    onClick = {}
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                            .padding(horizontal = 12.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .height(32.dp)
                        )

                        Text(
                            text = stringResource(R.string.find_recent_room),
                            style = RoomieTheme.typography.heading5Sb18,
                            color = RoomieTheme.colors.grayScale12
                        )

                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )

                    }
                }

                items(count = 3, key = { it }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                    ) {
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
                                isPinned = false,
                                moodTag = "#차분한",
                                contract_term = 6,
                                mainImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg"
                            ),
                            onClick = { },
                            onLikeClick = { }
                        )
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )

                        RoomieNavigateButton(
                            modifier = Modifier
                                .padding(horizontal = 16.dp),
                            type = NavigateButtonType.HOME,
                            text = stringResource(R.string.find_more_sharehouses_in_map)
                        )

                        Spacer(
                            modifier = Modifier
                                .height(120.dp)
                        )
                    }
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
                item {
                    AsyncImage(
                        model = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg",
                        contentDescription = "iloveandroidroomies",
                        modifier = Modifier.size(height),
                        contentScale = ContentScale.Crop
                    )
                }

                item {
                    Text(
                        modifier = Modifier.padding(top = 30.dp),
                        text = state.data,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeGreetingMessage(
    nickname: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = nickname,
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.primary
        )

        Text(
            text = stringResource(R.string.user_is),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale12
        )
    }

    Spacer(
        modifier = Modifier
            .height(4.dp)
    )

    Text(
        modifier = modifier,
        text = stringResource(R.string.welcome_to_roomie),
        style = RoomieTheme.typography.heading2Sb20,
        color = RoomieTheme.colors.grayScale12
    )

    Spacer(
        modifier = Modifier
            .height(12.dp)
    )

    Text(
        modifier = modifier,
        text = stringResource(R.string.roomie_find_perfect_home, nickname),
        style = RoomieTheme.typography.body4R12,
        color = RoomieTheme.colors.grayScale7
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    RoomieAndroidTheme {
        HomeScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            state = UiState.Loading
        )
    }
}