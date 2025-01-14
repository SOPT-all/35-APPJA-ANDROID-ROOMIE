package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailInfoTextWithIcon(
    leadingIcon: @Composable () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        leadingIcon()

        Spacer(Modifier.width(4.dp))

        Text(
            text = text,
            style = RoomieTheme.typography.body1R14,
            color = RoomieTheme.colors.grayScale10
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailInfoTextWithIconPreview(){
    RoomieAndroidTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ){
                DetailInfoTextWithIcon(
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_detail_location_20px),
                            contentDescription = null,
                            tint = RoomieTheme.colors.grayScale10
                        )
                    },
                    text = "서대문구 연희동"
                )

                DetailInfoTextWithIcon(
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_detail_totalpeople_20px),
                            contentDescription = null,
                            tint = RoomieTheme.colors.grayScale10
                        )
                    },
                    text = "2/4인"
                )

                DetailInfoTextWithIcon(
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_detail__calendar_20px),
                            contentDescription = null,
                            tint = RoomieTheme.colors.grayScale10
                        )
                    },
                    text = "3개월 이상 계약"
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ){
                DetailInfoTextWithIcon(
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_detail_room_20px),
                            contentDescription = null,
                            tint = RoomieTheme.colors.grayScale10
                        )
                    },
                    text = "1,2인실"
                )

                DetailInfoTextWithIcon(
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_detail_gender_20px),
                            contentDescription = null,
                            tint = RoomieTheme.colors.grayScale10
                        )
                    },
                    text = "여성전용"
                )
            }
        }

    }
}