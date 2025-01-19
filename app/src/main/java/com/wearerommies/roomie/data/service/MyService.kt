package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.ResponseMyPageDto
import retrofit2.http.GET

interface MyService {
    @GET("/v1/users/home") //todo: 패스 확인
    suspend fun getMyPageData(
    ): BaseResponse<ResponseMyPageDto>
}