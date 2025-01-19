package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.ResponseBookmarkListDto
import com.wearerommies.roomie.data.service.BookmarkListService
import javax.inject.Inject

internal class BookmarkListDataSource @Inject constructor(
    private val bookmarkListService: BookmarkListService
) {
    suspend fun getBookmarkLists(): BaseResponse<ResponseBookmarkListDto> =
        bookmarkListService.getBookmarkLists()
}