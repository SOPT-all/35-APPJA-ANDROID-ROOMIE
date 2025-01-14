package com.wearerommies.roomie.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.wearerommies.roomie.presentation.core.component.RoomieNavigateButton
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.presentation.type.NavigateButtonType
import com.wearerommies.roomie.presentation.ui.mypage.component.MyButtonWithHelperText
import com.wearerommies.roomie.presentation.ui.mypage.component.MyProfileCard
import com.wearerommies.roomie.presentation.ui.mypage.component.MyTitleBox
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: MyViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getUserInfo()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MySideEffect.ShowToast -> context.showToast(message = sideEffect.message)
                }
            }
    }

    MyScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state.uiState
    )

}

@Composable
fun MyScreen(
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
            .background(Color.White)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state) {
            is UiState.Loading -> {
                item {
                    RoomieTopBar(
                        title = "로딩중.."
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
                item {
                    RoomieTopBar(
                        title = "마이페이지"
                    )

                    MyProfileCard(
                        profileImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg",
                        nickname = "이루미",
                        onClick = {}
                    )

                    Spacer(
                        modifier = Modifier
                            .background(color = RoomieTheme.colors.grayScale3)
                            .fillMaxWidth()
                            .height(12.dp)
                    )

                    MyTitleBox(
                        text = "루미 더보기"
                    )


                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "찜 리스트"
                    )

                    MyButtonWithHelperText(
                        mainText = "쉐어하우스 찾기",
                        helperText = "원하는 매물이 없다면 새로 요청해보세요",
                        onClick = {}
                    )

                    MyButtonWithHelperText(
                        mainText = "매물 등록하기",
                        helperText = "쉐어하우스 사장님이라면 매물을 등록해보세요",
                        onClick = {}
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "의견 보내기"
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 8.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(color = RoomieTheme.colors.grayScale4)
                    )

                    MyTitleBox(
                        text = "루미 서비스 정보"
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "서비스 소개"
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "최근 소식"
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "약관 및 정책"
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = "앱 버전"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MyScreenPreview() {
    RoomieAndroidTheme {
        MyScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            state = UiState.Loading
        )
    }
}