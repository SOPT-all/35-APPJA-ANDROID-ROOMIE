package com.wearerommies.roomie.data.service

import com.wearerommies.roomie.data.dto.request.RequestTourApplyDto
import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseTourApplyDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface RoomService {
    @POST("/v1/rooms/{room_id}/tour-requests")
    suspend fun postRoomTourApply(
        @Path("room_id") roomId: Long,
        @Body request: RequestTourApplyDto
    ): BaseResponse<ResponseTourApplyDto>

}