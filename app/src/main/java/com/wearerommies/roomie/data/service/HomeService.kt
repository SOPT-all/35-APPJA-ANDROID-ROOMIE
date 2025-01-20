package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseHomeDto
import retrofit2.http.GET

interface HomeService {
    @GET("/v1/users/home")
    suspend fun getHomeData(): BaseResponse<ResponseHomeDto>
}