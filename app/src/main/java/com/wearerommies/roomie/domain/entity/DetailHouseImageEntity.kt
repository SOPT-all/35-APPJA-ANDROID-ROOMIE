package com.wearerommies.roomie.domain.entity

import kotlinx.collections.immutable.PersistentList

data class DetailHouseImageEntity(
    val mainImageUrl: String,
    val mainImageDescription: String,
    val facilityImageUrls: PersistentList<String>,
    val facilityImageDescription: String,
    val floorImageUrl: String
)