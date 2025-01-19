package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DetailImagePager(
    images: PersistentList<String>,
    @StringRes contentDescription: Int,
    modifier: Modifier = Modifier
) {

    val pagerState = rememberPagerState(
        pageCount = { images.size }
    )

    HorizontalPager(
        state = pagerState,

        beyondViewportPageCount = 1,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.BottomEnd
        ) {
            AsyncImage(
                model = images[it],
                contentDescription = stringResource(contentDescription),
                modifier = Modifier
                    .aspectRatio(360f / 312f),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = stringResource(
                    id = R.string.detail_image_indicator,
                    formatArgs = arrayOf((pagerState.currentPage + 1), images.size)
                ),
                color = RoomieTheme.colors.grayScale1,
                style = RoomieTheme.typography.caption3M10,
                modifier = Modifier
                    .padding(
                        end = 8.dp,
                        bottom = 8.dp
                    )
                    .background(
                        color = RoomieTheme.colors.transparentGray1250,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    )
            )
        }
    }
}

@Preview
@Composable
fun DetailImagePagerPreview() {
    RoomieAndroidTheme {
        DetailImagePager(
            images = persistentListOf(
                "https://i.pravatar.cc/300",
                "https://i.pravatar.cc/600"
            ),
            contentDescription = R.string.house_main_image,
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                    horizontal = 8.dp
                )
        )

    }
}