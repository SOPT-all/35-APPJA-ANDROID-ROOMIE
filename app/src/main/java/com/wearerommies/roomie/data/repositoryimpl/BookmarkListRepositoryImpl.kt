package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.BookmarkListDataSource
import com.wearerommies.roomie.domain.entity.RoomCardEntity
import com.wearerommies.roomie.domain.repository.BookmarkListRepository
import javax.inject.Inject

internal class BookmarkListRepositoryImpl @Inject constructor(
    private val bookmarkListDataSource: BookmarkListDataSource
) : BookmarkListRepository {
    override suspend fun getBookmarkLists(): Result<List<RoomCardEntity>> =
        runCatching {
            bookmarkListDataSource.getBookmarkLists().data.toEntity()
        }
}