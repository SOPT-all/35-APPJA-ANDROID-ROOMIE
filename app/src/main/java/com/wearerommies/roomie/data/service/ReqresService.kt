package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.response.ResponseReqresDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresService {
    @GET("api/users")
    suspend fun getReqresLists(
        @Query("page") page: Int
    ): ResponseReqresDto
}
