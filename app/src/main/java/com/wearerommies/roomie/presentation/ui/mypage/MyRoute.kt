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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieNavigateButton
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.extension.showToast
import com.wearerommies.roomie.presentation.core.extension.topBorder
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.presentation.type.MyType
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
                        title = stringResource(R.string.mypage)
                    )

                    MyProfileCard(
                        modifier = Modifier
                            .topBorder(
                                convertDpToFloat(1.dp),
                                color = RoomieTheme.colors.grayScale4
                            ),
                        profileImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg",
                        nickname = "이루미",
                        onClick = {}
                    )

                    Spacer(
                        modifier = Modifier
                            .topBorder(
                                convertDpToFloat(1.dp),
                                color = RoomieTheme.colors.grayScale4
                            )
                            .background(color = RoomieTheme.colors.grayScale3)
                            .fillMaxWidth()
                            .height(12.dp)
                    )

                    MyTitleBox(
                        modifier = Modifier
                            .topBorder(
                                convertDpToFloat(1.dp),
                                color = RoomieTheme.colors.grayScale4
                            ),
                        text = stringResource(R.string.show_more_roomie)
                    )


                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = stringResource(R.string.bookmark_list)
                    )

                    MyButtonWithHelperText(
                        mainText = stringResource(R.string.find_sharehouses),
                        helperText = stringResource(R.string.request_new_room),
                        onClick = {}
                    )

                    MyButtonWithHelperText(
                        mainText = stringResource(R.string.add_new_room),
                        helperText = stringResource(R.string.register_sharehouse_owner),
                        onClick = {}
                    )

                    RoomieNavigateButton(
                        type = NavigateButtonType.MY,
                        text = stringResource(R.string.send_feedback)
                    )

                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 8.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(color = RoomieTheme.colors.grayScale4)
                    )

                    MyTitleBox(
                        text = stringResource(R.string.service_infomation)
                    )

                    MyType.entries.forEach { type ->
                        RoomieNavigateButton(
                            type = NavigateButtonType.MY,
                            text = stringResource(type.title)
                        )
                    }
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