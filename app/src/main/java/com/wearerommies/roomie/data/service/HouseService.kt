package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseBookmarkListDto
import com.wearerommies.roomie.data.dto.response.ResponseDetailDto
import com.wearerommies.roomie.data.dto.response.ResponseDetailRoomDto
import com.wearerommies.roomie.data.dto.response.ResponseMoodDto
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface HouseService {
    @GET("/v1/houses")
    suspend fun getMoodLists(
        @Query("moodTag") moodTag: String
    ): BaseResponse<ResponseMoodDto>

    @GET("/v1/houses/pins")
    suspend fun getBookmarkLists(): BaseResponse<ResponseBookmarkListDto>

    @PATCH("/v1/houses/{houseId}/pins")
    suspend fun bookmarkHouse(
        @Path("houseId") houseId: Long
    ): BaseResponse<Boolean>

    @GET("/v1/houses/{houseId}/details")
    suspend fun getHouseDetail(
        @Path("houseId") houseId: Long
    ): BaseResponse<ResponseDetailDto>

    @GET("/v1/houses/{houseId}/details/rooms")
    suspend fun getRoomDetail(
        @Path("houseId") houseId: Long
    ): BaseResponse<ResponseDetailRoomDto>
}