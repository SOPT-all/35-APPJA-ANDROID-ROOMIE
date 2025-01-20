package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.datasource.HomeDataSource
import com.wearerommies.roomie.data.datasource.HouseDataSource
import com.wearerommies.roomie.data.datasource.ReqresDataSource
import com.wearerommies.roomie.data.service.HomeService
import com.wearerommies.roomie.data.service.HouseService
import com.wearerommies.roomie.data.service.ReqresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {
    @Provides
    @Singleton
    fun providesReqresDataSource(
        reqresService: ReqresService
    ): ReqresDataSource = ReqresDataSource(reqresService)

    @Provides
    @Singleton
    fun providesHomeDataSource(
        homeService: HomeService
    ): HomeDataSource = HomeDataSource(homeService)

    @Provides
    @Singleton
    fun providesHouseDataSource(
        houseService: HouseService
    ): HouseDataSource = HouseDataSource(houseService)
}
