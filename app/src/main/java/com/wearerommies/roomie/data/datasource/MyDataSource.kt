package com.wearerommies.roomie.data.datasource

import com.wearerommies.roomie.data.dto.response.ResponseMyPageDto
import com.wearerommies.roomie.data.service.MyService
import javax.inject.Inject

internal class MyDataSource @Inject constructor(
    private val myService: MyService
) {

}