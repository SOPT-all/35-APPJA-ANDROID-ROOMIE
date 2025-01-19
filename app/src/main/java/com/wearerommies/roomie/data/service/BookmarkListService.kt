package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.ResponseBookmarkListDto
import retrofit2.http.GET

interface BookmarkListService {
    @GET("/v1/users/home") //todo: 패스 확인
    suspend fun getBookmarkLists(
    ): BaseResponse<ResponseBookmarkListDto>
}