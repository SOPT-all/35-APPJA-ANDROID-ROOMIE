package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseMoodDto
import com.wearerommies.roomie.data.service.HouseService
import javax.inject.Inject

class HouseDataSource @Inject constructor(
    private val houseService: HouseService
) {
    suspend fun getMoodLists(moodTag: String): BaseResponse<ResponseMoodDto> =
        houseService.getMoodLists(moodTag = moodTag)
}
