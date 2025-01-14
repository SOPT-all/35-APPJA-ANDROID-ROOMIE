package com.wearerommies.roomie.presentation.ui.home

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
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.util.UiState
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

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<String>,
    modifier: Modifier = Modifier
) {
    val screenWeigth = LocalConfiguration.current.screenWidthDp
    val height = (screenWeigth * 0.5).dp

    LazyColumn(
        modifier = modifier
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
                item {
                    RoomieTopBar(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 4.dp),
                        backgroundColor = Color.Transparent,
                        leadingIcon = {
                            Row(
                                modifier = Modifier
                                    .padding(all = 8.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "연남동",
                                    style = RoomieTheme.typography.title2Sb16,
                                    color = RoomieTheme.colors.grayScale12
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_line_black_16px),
                                    contentDescription = "백버튼"
                                )
                            }
                        },
                        trailingIcon = {
                            Icon(
                                modifier = Modifier
                                    .noRippleClickable {
                                    }
                                    .padding(all = 8.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.ic_heart_line_black_24px),
                                contentDescription = null
                            )
                        }
                    )

                    Spacer(
                        modifier = Modifier
                            .height(32.dp)
                    )

                    HomeGreetingMessage(
                        modifier = Modifier.padding(
                            start = 20.dp
                        )
                    )

                    Spacer(
                        modifier = Modifier
                            .height(66.dp)
                    )

                    RoomieNavigateButton(
                        modifier = Modifier
                            .padding(start = 19.dp, end = 21.dp),
                        type = NavigateButtonType.UPDATE,
                        text = "1월 1일 루미 업데이트 알아보기",
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
                                text = "분위기 별로 보기",
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

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White)
                            .padding(horizontal = 12.dp)
                    ) {
                        Column {
                            Spacer(
                                modifier = Modifier
                                    .height(32.dp)
                            )

                            Text(
                                text = "최근 본 방",
                                style = RoomieTheme.typography.heading5Sb18,
                                color = RoomieTheme.colors.grayScale12
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )

                            RoomieRoomCard(
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

                            Spacer(
                                modifier = Modifier
                                    .height(20.dp)
                            )

                            RoomieNavigateButton(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp),
                                type = NavigateButtonType.HOME,
                                text = "지도에서 더 많은 쉐어하우스 찾기"
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(24.dp)
                            )
                        }
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
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "nickname",
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.primary
        )

        Text(
            text = stringResource(R.string.user_hello),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale12
        )
    }

    Spacer(
        modifier = Modifier
            .height(12.dp)
    )

    Text(
        modifier = modifier,
        text = "루미가 루미님의 완벽한 집을\n찾아드릴게요",
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