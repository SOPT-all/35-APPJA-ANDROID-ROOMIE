package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseSearchDto
import com.wearerommies.roomie.data.service.MapService
import javax.inject.Inject

class MapDataSource @Inject constructor(
    private val mapService: MapService
) {
    suspend fun getSearchResult(q: String): BaseResponse<ResponseSearchDto> =
        mapService.getSearchResult(q = q)
}
