package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseMoodDto
import com.wearerommies.roomie.data.service.MoodService
import javax.inject.Inject

class MoodDataSource @Inject constructor(
    private val moodService: MoodService
) {
    suspend fun getMoodLists(moodTag: String): BaseResponse<ResponseMoodDto> =
        moodService.getMoodLists(moodTag = moodTag)
}
