package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.request.RequestTourApplyDto
import com.wearerommies.roomie.data.dto.response.BaseResponse
import com.wearerommies.roomie.data.dto.response.ResponseTourApplyDto
import com.wearerommies.roomie.data.service.RoomService
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    private val roomService: RoomService
) {
    suspend fun postRoomTourApply(roomId: Long, request: RequestTourApplyDto): BaseResponse<ResponseTourApplyDto> =
        roomService.postRoomTourApply(roomId = roomId, request = request)
}