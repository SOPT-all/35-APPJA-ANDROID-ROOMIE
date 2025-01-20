package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.service.HomeService
import com.wearerommies.roomie.data.service.HouseService
import com.wearerommies.roomie.data.service.ReqresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {
    @Provides
    @Singleton
    fun provideReqresService(retrofit: Retrofit): ReqresService =
        retrofit.create(ReqresService::class.java)

    @Provides
    @Singleton
    fun provideHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)

    @Provides
    @Singleton
    fun provideHouseService(retrofit: Retrofit): HouseService =
        retrofit.create(HouseService::class.java)
}
