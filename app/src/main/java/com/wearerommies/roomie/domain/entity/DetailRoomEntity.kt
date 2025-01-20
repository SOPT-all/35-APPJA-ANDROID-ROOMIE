package com.wearerommies.roomie.domain.entity

import kotlinx.collections.immutable.PersistentList

data class DetailRoomEntity(
    val roomId: Long,
    val name: String,
    val facility: PersistentList<String>,
    val status: Boolean,
    val imagesUrl: PersistentList<String>
)