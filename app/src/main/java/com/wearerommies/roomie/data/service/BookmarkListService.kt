package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseBookmarkListDto
import retrofit2.http.GET

interface BookmarkListService {
    @GET("/v1/houses/pins")
    suspend fun getBookmarkLists(
    ): BaseResponse<ResponseBookmarkListDto>
}