package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseHomeDto
import com.wearerommies.roomie.data.service.HomeService
import javax.inject.Inject

internal class HomeDataSource @Inject constructor(
    private val homeService: HomeService
) {
    suspend fun getHomeData(): BaseResponse<ResponseHomeDto> =
        homeService.getHomeData()
}