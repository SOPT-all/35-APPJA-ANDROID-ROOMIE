package com.wearerommies.roomie.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.presentation.type.HomeMoodCardType
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun HomeMoodCard(
    homeMoodCardType: HomeMoodCardType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .height((LocalConfiguration.current.screenHeightDp * 0.251).dp)
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = RoomieTheme.colors.primaryLight5,
                borderColor = RoomieTheme.colors.primaryLight3,
                borderWidth = 1.dp
            )
            .clickable {
                onClick()
            }
            .padding(top = 12.dp),
    ) {
        MoodCardMainText(
            modifier = Modifier
                .padding(start = 12.dp, end = 10.dp),
            homeMoodCardType = homeMoodCardType
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )

        Text(
            modifier = Modifier
                .padding(start = 12.dp),
            text = stringResource(homeMoodCardType.moodTag) + " " + stringResource(R.string.mood_card_sub_text),
            style = RoomieTheme.typography.caption1R10,
            color = RoomieTheme.colors.primaryLight1,
        )

        Spacer(
            modifier = Modifier
                .height(4.dp)
        )

        Image(
            painter = painterResource(homeMoodCardType.moodDrawableResId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun MoodCardMainText(homeMoodCardType: HomeMoodCardType, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "#",
            style = RoomieTheme.typography.body2Sb14,
            color = RoomieTheme.colors.primary,
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = stringResource(homeMoodCardType.moodTag),
            style = RoomieTheme.typography.body2Sb14,
            color = RoomieTheme.colors.primary,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_line_black_16px),
            contentDescription = null,
            tint = RoomieTheme.colors.primary
        )
    }
}

@Preview
@Composable
private fun HomeMoodCardPreview() {
    RoomieAndroidTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HomeMoodCard(
                homeMoodCardType = HomeMoodCardType.CALM,
                onClick = {}
            )

            HomeMoodCard(
                homeMoodCardType = HomeMoodCardType.ACTIVE,
                onClick = {}
            )

            HomeMoodCard(
                homeMoodCardType = HomeMoodCardType.CLEAN,
                onClick = {}
            )
        }
    }
}