package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieTextChip
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DetailMoodCard(
    roomMood: String,
    roomMoodTag: PersistentList<String>,
    groundRule: PersistentList<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = RoomieTheme.colors.grayScale1,
                borderColor = RoomieTheme.colors.grayScale5,
            )
            .padding(16.dp)
    ) {
        Text(
            text = roomMood,
            style = RoomieTheme.typography.body1R14,
            color = RoomieTheme.colors.grayScale12
        )

        Spacer(Modifier.height(16.dp))

        DetailMoodTagChips(
            roomMoodTag = roomMoodTag
        )

        Spacer(Modifier.height(12.dp))

        HorizontalDivider(
            modifier = Modifier
                .background(RoomieTheme.colors.grayScale4)
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.ground_rule),
            style = RoomieTheme.typography.body2Sb14,
            color = RoomieTheme.colors.grayScale12
        )

        Spacer(Modifier.height(16.dp))

        DetailGroundRuleTexts(
            groundRule = groundRule
        )
    }
}

@Composable
fun DetailMoodTagChips(
    roomMoodTag: PersistentList<String>,
    modifier: Modifier = Modifier
) {
    LazyRow (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(roomMoodTag) { index, item ->
            val isMainMoodTag = index == 0
            RoomieTextChip(
                text = item,
                textColor = if(isMainMoodTag) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale9,
                backgroundColor = if(isMainMoodTag) RoomieTheme.colors.primaryLight4 else RoomieTheme.colors.grayScale3
            )
        }
    }
}

@Composable
fun DetailGroundRuleTexts(
    groundRule: PersistentList<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        itemsIndexed(groundRule) { index, item ->
            DetailTextWithCheckIcon(
                text = item
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x000000)
@Composable
fun DetailMoodCardPreview() {
    RoomieAndroidTheme {
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            DetailMoodCard(
                roomMood = "해피쉐어 12호점은 전반적으로 조용하고 깔끔한 환경을 선호하는 아침형 룸메이트들로 이루어져 차분하고 아늑한 분위기입니다.",
                roomMoodTag = persistentListOf("차분한", "활기찬", "깔끔한"),
                groundRule = persistentListOf(
                    "요리 후 바로 설거지해요",
                    "유통기한이 1주일이 지난 음식은 버려요",
                    "큰 소리로 통화하지 않아요",
                    "청소는 주 3회 돌아가면서 하고 빠질시 어쩍구저저구에용 2줄예시를 보여드리고 있어용 3줄은 이렇게 되네요 우오아와"
                )
            )
        }
    }
}