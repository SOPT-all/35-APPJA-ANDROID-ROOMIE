package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseMoodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HouseService {
    @GET("/v1/houses")
    suspend fun getMoodLists(
        @Query("moodTag") moodTag: String
    ): BaseResponse<ResponseMoodDto>
}