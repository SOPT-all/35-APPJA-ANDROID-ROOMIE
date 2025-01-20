package com.wearerommies.roomie.presentation.ui.detail.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.DetailRoomEntity
import com.wearerommies.roomie.presentation.core.component.RoomieTopBar
import com.wearerommies.roomie.presentation.core.extension.bottomBorder
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.presentation.core.util.UiState
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.presentation.ui.detail.component.DetailImagePager
import com.wearerommies.roomie.presentation.ui.detail.component.DetailInnerFacilityCard
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

@Composable
fun DetailRoomRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: DetailRoomViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    // TODO: 하우스 이름 navigation으로 전달
}

@Composable
fun DetailRoomScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<List<DetailRoomEntity>>,
    // TODO: 뷰모델 state 상태관리
    expandedRoomList: PersistentList<Long>,
    modifier: Modifier = Modifier
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(RoomieTheme.colors.grayScale1)
            .padding(paddingValues),
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
            },
            title = "루미 1호점", // TODO: 하우스 이름 navigation으로 전달
            modifier = Modifier
                .bottomBorder(
                    color = RoomieTheme.colors.grayScale4,
                    height = convertDpToFloat(1.dp)
                )
        )

        when(state) {
            UiState.Failure -> TODO()
            UiState.Loading -> TODO()
            is UiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {

                    item {
                        Spacer(Modifier.height(32.dp))

                        Text(
                            text = stringResource(R.string.room_facility),
                            style = RoomieTheme.typography.heading5Sb18,
                            color = RoomieTheme.colors.grayScale12
                        )

                        Spacer(Modifier.height(16.dp))
                    }

                    itemsIndexed(state.data) { index, room ->
                        val isExpanded = expandedRoomList.contains(room.roomId)

                        DetailInnerFacilityCard(
                            text = room.name,
                            facility = room.facility.toPersistentList(),
                            onClickExpandedButton = {
                                if(isExpanded) {
                                    expandedRoomList.remove(room.roomId)
                                } else {
                                    expandedRoomList.add(room.roomId)
                                }
                            },
                            imageContent = {

                                Spacer(Modifier.height(12.dp))

                                DetailImagePager(
                                    images = room.imagesUrl,
                                    modifier = Modifier
                                        .height((screenHeight * 0.235).dp),
                                    contentDescription = stringResource(R.string.room_image)
                                )
                            },
                            roomStatus = room.status,
                            isExpanded = isExpanded
                        )

                        if(index != state.data.lastIndex){
                            Spacer(Modifier.height(10.dp))
                        } else {
                            Spacer(Modifier.height(28.dp))
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailRoomScreenPreview() {

    val expandedRoomList = persistentListOf(1L, 3L, 6L)

    RoomieAndroidTheme {
        DetailRoomScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            expandedRoomList = expandedRoomList,
            state = UiState.Success(
                listOf(
                    DetailRoomEntity(
                        roomId = 1L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트", "테스트"),
                        status = true,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300"
                        )
                    ),
                    DetailRoomEntity(
                        roomId = 2L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트"),
                        status = false,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                        )
                    ),
                    DetailRoomEntity(
                        roomId = 3L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트"),
                        status = true,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                        )
                    ),
                    DetailRoomEntity(
                        roomId = 4L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트"),
                        status = false,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                        )
                    ),
                    DetailRoomEntity(
                        roomId = 5L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트"),
                        status = true,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                        )
                    ),
                    DetailRoomEntity(
                        roomId = 6L,
                        name = "테스트",
                        facility = persistentListOf("테스트", "테스트"),
                        status = false,
                        imagesUrl = persistentListOf(
                            "https://i.pravatar.cc/300",
                            "https://i.pravatar.cc/300",
                        )
                    )
                )
            )
        )
    }
}