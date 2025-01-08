package com.wearerommies.roomie.data.mapper.todomain

import com.wearerommies.roomie.data.dto.response.ResponseReqresDto
import com.wearerommies.roomie.domain.entity.ReqresEntity

fun ResponseReqresDto.toReqresEntity() = data.map {
    ReqresEntity(
        avatar = it.avatar,
        email = it.email,
        firstName = it.firstName,
        lastName = it.lastName
    )
}
