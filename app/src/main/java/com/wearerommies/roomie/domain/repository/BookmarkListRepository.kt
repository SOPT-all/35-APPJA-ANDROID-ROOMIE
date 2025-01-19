package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.RoomCardEntity

interface BookmarkListRepository {
    suspend fun getBookmarkLists(): Result<List<RoomCardEntity>>
}