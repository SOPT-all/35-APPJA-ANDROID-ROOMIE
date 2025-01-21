package com.wearerommies.roomie.presentation.ui.home

import com.wearerommies.roomie.domain.entity.HomeDataEntity
import com.wearerommies.roomie.domain.entity.RoomCardEntity

data class HomeState(
    val uiState: HomeDataEntity = HomeDataEntity(
        name = "닉네임",
        location = "연남동",
        recentlyViewedHouses = listOf(
            RoomCardEntity(
                houseId = 1,
                monthlyRent = "30~50",
                deposit = "200~300",
                occupancyType = "2인실",
                location = "서대문구 연희동",
                genderPolicy = "여성전용",
                locationDescription = "자이아파트",
                isPinned = false,
                moodTag = "#차분한",
                contractTerm = 6,
                mainImgUrl = "https://i.pinimg.com/236x/12/95/67/1295676da767fa8171baf8a307b5786c.jpg"
            ),
        )
    )
)