package com.wearerommies.roomie.presentation.ui.map.component;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.component.RoomieRoomCard
import com.wearerommies.roomie.presentation.core.extension.topBorder
import com.wearerommies.roomie.presentation.core.util.convertDpToFloat
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapBotomSheet(modifier: Modifier = Modifier) {
    BottomSheetScaffold(
        modifier = modifier.padding(top = (LocalConfiguration.current.screenHeightDp * 0.151).dp),
        sheetPeekHeight = (LocalConfiguration.current.screenHeightDp * 0.077).dp,
        sheetContainerColor = RoomieTheme.colors.grayScale1,
        sheetShadowElevation = 4.dp,
        sheetDragHandle = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier
                        .padding(top = 11.dp, bottom = 14.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(RoomieTheme.colors.grayScale5)
                        .width(36.dp)
                        .height(4.dp)
                )
                Text(
                    text = stringResource(R.string.house),
                    style = RoomieTheme.typography.title2Sb16,
                    color = RoomieTheme.colors.grayScale12,
                    modifier = Modifier.padding(bottom = 9.dp)
                )
            }
        },
        sheetContent = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .topBorder(convertDpToFloat(1.dp), RoomieTheme.colors.grayScale4)
                    .padding(start = 11.dp, end = 13.dp)
                    .heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.67).dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }

                items(
                    count = 20
                ) {
                    RoomieRoomCard(
                        roomCardEntity = RoomCardEntity(
                            houseId = 1,
                            monthlyRent = "30~50",
                            deposit = "200~300",
                            occupancyType = "2,3인실",
                            location = "서대문구 연희동",
                            genderPolicy = "여성전용",
                            locationDescription = "자이아파트",
                            moodTag = "#아늑한",
                            contractTerm = 6,
                            mainImgUrl = "https://i.pinimg.com/236x/44/f9/83/44f9831be884e4c65f167b96e16fa94e.jpg"
                        ),
                        onClick = {}, // TODO: 해당뷰에서는 리플효과 사용하지 않음
                        onLikeClick = {},
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(43.dp))
                }
            }
        },
        content = {}
    )
}

@Preview
@Composable
fun MapBottomSheetPreview() {
    RoomieAndroidTheme {
        MapBotomSheet()
    }
}
