package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.ResponseMoodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MoodService {
    @GET("api/users")
    suspend fun getMoodLists(
        @Query("moodTag") moodTag: String
    ): ResponseMoodDto
}