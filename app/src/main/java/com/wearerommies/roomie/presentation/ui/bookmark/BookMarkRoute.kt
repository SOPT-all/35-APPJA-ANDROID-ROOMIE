package com.wearerommies.roomie.presentation.ui.bookmark

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.launch

@Composable
fun BookMarkRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: BookMarkViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val snackBarHost = remember { SnackbarHostState() }
    val counter by remember { mutableIntStateOf(0) }

    val currentCounter by rememberUpdatedState(counter)

    LaunchedEffect(currentCounter) {
        viewModel.getBookMarkList()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is BookMarkSideEffect.ShowToast -> context.showToast(message = sideEffect.message)
                    is BookMarkSideEffect.SnackBar -> {
                        snackBarHost.currentSnackbarData?.dismiss()
                        snackBarHost.showSnackbar(
                            message = context.getString(sideEffect.message),
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
    }

    BookMarkScreen(
        paddingValues = paddingValues,
        snackBarHost = snackBarHost,
        navigateUp = navigateUp,
        onLikeClick = viewModel::patchHousePin,
        state = state.uiState
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookMarkScreen(
    paddingValues: PaddingValues,
    snackBarHost: SnackbarHostState,
    navigateUp: () -> Unit,
    state: UiState<String>,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val screenWeight = LocalConfiguration.current.screenWidthDp
    val height = (screenWeight * 0.5).dp
    val coroutineScope = rememberCoroutineScope()

    Popup(
        alignment = Alignment.BottomCenter
    ) {
        SnackbarHost(hostState = snackBarHost) { snackbarData ->
            RoomieSnackbar(
                modifier = Modifier
                    .padding(
                        bottom = 24.dp,
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
            .background(RoomieTheme.colors.grayScale1)
            .padding(paddingValues),
    ) {
        when (state) {
            is UiState.Loading -> {
                item {
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
                        title = stringResource(R.string.bookmark_list)
                    )
                }

                items(count = 3, key = { it }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = RoomieTheme.colors.grayScale1)
                    ) {
                        RoomieRoomCard(
                            modifier = Modifier
                                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp),
                            roomCardEntity = RoomCardEntity(
                                houseId = 1,
                                monthlyRent = "30~50",
                                deposit = "200~300",
                                occupancyType = "2인실",
                                location = "서대문구 연희동",
                                genderPolicy = "여성전용",
                                locationDescription = "자이아파트",
                                isPinned = true,
                                moodTag = "#차분한",
                                contractTerm = 6,
                                mainImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg"
                            ),
                            onClick = { },
                            onLikeClick = {
                                coroutineScope.launch { onLikeClick() }
                            }
                        )
                    }
                }

                item {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = RoomieTheme.colors.grayScale1)
                            .height(20.dp)
                    )

                    RoomieFooter()
                }
            }
        }
    }
}

@Preview
@Composable
fun BookMarkScreenPreview() {
    RoomieAndroidTheme {
        BookMarkScreen(
            paddingValues = PaddingValues(),
            snackBarHost = remember { SnackbarHostState() },
            navigateUp = {},
            onLikeClick = {},
            state = UiState.Success("")
        )
    }
}