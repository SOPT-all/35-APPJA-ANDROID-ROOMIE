package com.wearerommies.roomie.presentation.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wearerommies.roomie.R
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.presentation.core.extension.noRippleClickable
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun RoomieRoomCard(
    roomCardEntity: RoomCardEntity,
    onClick: () -> Unit,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height((LocalConfiguration.current.screenHeightDp * 0.144).dp)
            .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
            .clickable { onClick() }
            .padding(all = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box {
            AsyncImage(
                model = roomCardEntity.mainImgUrl,
                contentDescription = stringResource(R.string.main_room_image),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            RoomieTextChip(
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp),
                text = roomCardEntity.moodTag,
                textStyle = RoomieTheme.typography.caption2Sb10,
                textColor = RoomieTheme.colors.grayScale12,
                backgroundColor = RoomieTheme.colors.transparentGray160,
            )

            Box(
                modifier = Modifier
                    .width(140.dp)
                    .padding(end = 6.dp, top = 6.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    modifier = Modifier
                        .noRippleClickable {
                            onLikeClick()
                        },
                    imageVector = if (roomCardEntity.isPinned)
                        ImageVector.vectorResource(R.drawable.ic_heart_filled_white_24px) else ImageVector.vectorResource(
                        R.drawable.ic_heart_linewithfill_white_24px
                    ),
                    contentDescription = null,
                    tint = Color.White
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 7.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = "월세 ${roomCardEntity.monthlyRent}",
                    style = RoomieTheme.typography.title2Sb16,
                    color = RoomieTheme.colors.grayScale12
                )

                Spacer(modifier = Modifier.size(2.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "보증금 ${roomCardEntity.deposit}",
                        style = RoomieTheme.typography.body5Sb12,
                        color = RoomieTheme.colors.primary
                    )

                    Text(
                        text = "|",
                        style = RoomieTheme.typography.body5Sb12,
                        color = RoomieTheme.colors.primary
                    )

                    Text(
                        text = "${roomCardEntity.contract_term}개월",
                        style = RoomieTheme.typography.body5Sb12,
                        color = RoomieTheme.colors.primary
                    )
                }

                Spacer(modifier = Modifier.size(12.dp))

                DotWithText(
                    firstText = roomCardEntity.occupancyType,
                    secondText = roomCardEntity.genderPolicy
                )

                DotWithText(
                    firstText = roomCardEntity.location,
                    secondText = roomCardEntity.locationDescription
                )
            }
        }
    }
}

@Composable
private fun DotWithText(
    firstText: String,
    secondText: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            4.dp,
            alignment = Alignment.CenterHorizontally
        ),
    ) {
        Text(
            text = firstText,
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale7
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_middle_dot),
            contentDescription = null,
            tint = RoomieTheme.colors.grayScale7
        )
        Text(
            text = secondText,
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale7
        )
    }
}

@Preview
@Composable
private fun RoomieRoomCardPreview() {
    RoomieAndroidTheme {
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
                mainImgUrl = "https://example.com/images/house1.jpg"
            ),
            onClick = {},
            onLikeClick = {}
        )

    }
}