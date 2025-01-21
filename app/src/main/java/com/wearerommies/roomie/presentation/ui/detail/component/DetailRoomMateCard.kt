package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.presentation.core.util.RegexConstants
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DetailRoomMateCard(
    @DrawableRes image: Int,
    roomMateAge: String,
    roomMateJob: String,
    roomMateMbti: String,
    roomMateRoomName: String,
    roomMateSleepTime: String,
    roomMateActivityTime: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = RoomieTheme.colors.grayScale1,
                borderColor = RoomieTheme.colors.grayScale5,
                borderWidth = 1.dp
            )
            .padding(
                top = 12.dp,
                bottom = 12.dp,
                start = 12.dp,
                end = 23.dp
            )
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(R.string.roommate_image),
            modifier = Modifier
                .clip(CircleShape)
                .size(58.dp)
        )

        Spacer(Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(R.string.roommate_age_job, roomMateAge, roomMateJob),
                    style = RoomieTheme.typography.body2Sb14,
                    color = RoomieTheme.colors.grayScale12
                )

                Spacer(Modifier.width(8.dp))

                DetailRoomMateChip(roomMateMbti)

                Spacer(Modifier.width(4.dp))

                DetailRoomMateChip(roomMateRoomName)

            }

            Spacer(Modifier.height(8.dp))

            RoomMateTimeText(
                text = roomMateSleepTime,
                isSleepTime = true
            )

            Spacer(Modifier.height(2.dp))

            RoomMateTimeText(
                text = roomMateActivityTime,
                isSleepTime = false
            )
        }
    }
}

@Composable
fun RoomMateTimeText(
    text: String,
    modifier: Modifier = Modifier,
    isSleepTime: Boolean = true
) {

    Row(
        modifier = modifier
    ) {
        Text(
            text = if(isSleepTime) stringResource(R.string.roommate_sleep_time) else stringResource(R.string.roommate_activity_time),
            style = RoomieTheme.typography.body6M12,
            color = RoomieTheme.colors.grayScale8
        )

        Spacer(Modifier.width(4.dp))

        Text(
            text = text,
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale10
        )
    }
}



@Preview
@Composable
fun DetailRoomMateCardPreview() {
    RoomieAndroidTheme {
        DetailRoomMateCard(
            image = R.drawable.img_profile,
            roomMateAge = "20대 중반",
            roomMateJob = "대학생",
            roomMateMbti = "ENFP",
            roomMateRoomName = "룸A",
            roomMateSleepTime = "12:00-22:00",
            roomMateActivityTime = "12:00-22:00"
            )
    }
}