package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.repositoryimpl.HomeRepositoryImpl
import com.wearerommies.roomie.data.repositoryimpl.ReqresRepositoryImpl
import com.wearerommies.roomie.domain.repository.HomeRepository
import com.wearerommies.roomie.domain.repository.ReqresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun bindsReqresRepository(reqresRepositoryImpl: ReqresRepositoryImpl): ReqresRepository

    @Binds
    @Singleton
    fun bindsHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}
