package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.request.RequestFilterDto
import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseFilterDto
import com.wearerommies.roomie.data.dto.response.ResponseSearchDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MapService {
    @GET("/v1/locations")
    suspend fun getSearchResult(
        @Query("q") query: String
    ): BaseResponse<ResponseSearchDto>

    @POST("/v1/maps/search")
    suspend fun getFilterResult(
        @Body filter: RequestFilterDto
    ): BaseResponse<ResponseFilterDto>
}
