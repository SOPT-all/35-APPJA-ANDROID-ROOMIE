package com.wearerommies.roomie.data.repositoryimpl

import com.wearerommies.roomie.data.datasource.MyDataSource
import com.wearerommies.roomie.domain.entity.MyPageEntity
import com.wearerommies.roomie.domain.repository.MyRepository
import javax.inject.Inject

//internal class MyRepositoryImpl @Inject constructor(
//    private val myDataSource: MyDataSource
//) : MyRepository {
//    override suspend fun getMyPageData(): Result<MyPageEntity> =
//        runCatching {
//            myDataSource.getMyPageData().data.toEntity()
//        }
//}