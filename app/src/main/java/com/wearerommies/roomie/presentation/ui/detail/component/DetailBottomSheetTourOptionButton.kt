package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.presentation.core.extension.roundedBackgroundWithBorder
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailBottomSheetTourOptionButton(
    roomName: String,
    roomPrice: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    isEnabled: Boolean = true
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .roundedBackgroundWithBorder(
                cornerRadius = 8.dp,
                backgroundColor = when {
                    isSelected -> RoomieTheme.colors.primaryLight4
                    !isEnabled -> RoomieTheme.colors.grayScale4
                    else -> RoomieTheme.colors.grayScale1
                },
                borderColor = if(isSelected) RoomieTheme.colors.primary else RoomieTheme.colors.grayScale6,
                borderWidth = 1.dp
            )
            .padding(8.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = roomName,
            style = RoomieTheme.typography.title2Sb16,
            color = if(!isEnabled) RoomieTheme.colors.grayScale7 else RoomieTheme.colors.grayScale12,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = roomPrice,
            style = RoomieTheme.typography.body4R12,
            color = RoomieTheme.colors.grayScale7
        )
    }
}

@Preview
@Composable
fun DetailBottomSheetTourOptionButtonPreview() {
    RoomieAndroidTheme {

        Column {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                DetailBottomSheetTourOptionButton(
                    roomName = "룸A",
                    roomPrice = "500/50",
                    isSelected = true,
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(12.dp))

                DetailBottomSheetTourOptionButton(
                    roomName = "룸A",
                    roomPrice = "500/50",
                    isSelected = false,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                DetailBottomSheetTourOptionButton(
                    roomName = "룸A",
                    roomPrice = "500/50",
                    isSelected = true,
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(12.dp))

                DetailBottomSheetTourOptionButton(
                    roomName = "룸A",
                    roomPrice = "500/50",
                    isSelected = false,
                    isEnabled = false,
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}