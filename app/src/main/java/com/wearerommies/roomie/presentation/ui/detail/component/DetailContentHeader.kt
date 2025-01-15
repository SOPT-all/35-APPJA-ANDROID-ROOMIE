package com.wearerommies.roomie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wearerommies.roomie.R
import com.wearerommies.roomie.presentation.core.component.RoomieHouseNameChip
import com.wearerommies.roomie.ui.theme.RoomieAndroidTheme
import com.wearerommies.roomie.ui.theme.RoomieTheme

@Composable
fun DetailContentHeader(
    houseName: String,
    monthlyRent: String,
    deposit: String,
    location: String,
    occupancyStatus: String,
    contractTerm: Int,
    occupancyTypes: String,
    genderPolicy: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        RoomieHouseNameChip(
            text = houseName
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.house_price_text, monthlyRent, deposit),
            style = RoomieTheme.typography.heading2Sb20,
            color = RoomieTheme.colors.grayScale11
        )

        Spacer(Modifier.height(28.dp))

        DetailInfoWithIcons(
            location = location,
            occupancyStatus = occupancyStatus,
            contractTerm = contractTerm,
            occupancyTypes = occupancyTypes,
            genderPolicy = genderPolicy
        )

        Spacer(Modifier.height(32.dp))

        DetailInnerImageButton()

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun DetailInfoWithIcons(
    location: String,
    occupancyStatus: String,
    contractTerm: Int,
    occupancyTypes: String,
    genderPolicy: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ){
            DetailInfoTextWithIcon(
                icon = ImageVector.vectorResource(R.drawable.ic_detail_location_20px),
                text = location
            )

            DetailInfoTextWithIcon(
                icon = ImageVector.vectorResource(R.drawable.ic_detail_totalpeople_20px),
                text = stringResource(R.string.occupancy_status, occupancyStatus)
            )

            DetailInfoTextWithIcon(
                icon = ImageVector.vectorResource(R.drawable.ic_detail__calendar_20px),
                text = stringResource(R.string.contract_term, contractTerm)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ){
            DetailInfoTextWithIcon(
                icon = ImageVector.vectorResource(R.drawable.ic_detail_room_20px),
                text = occupancyTypes
            )

            DetailInfoTextWithIcon(
                icon = ImageVector.vectorResource(R.drawable.ic_detail_gender_20px),
                text = genderPolicy
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailContentHeaderPreview() {
    RoomieAndroidTheme {
        DetailContentHeader(
            houseName = "루미 100호점(이대역)",
            monthlyRent = "43~50",
            deposit = "90~100",
            location = "서대문구 연희동",
            occupancyStatus = "2/5",
            contractTerm = 3,
            occupancyTypes = "1,2인실",
            genderPolicy = "여성 전용"
        )
    }
}
