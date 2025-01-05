package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.repositoryimpl.ReqresRepositoryImpl
import com.wearerommies.roomie.domain.repository.ReqresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsReqresRepository(reqresRepositoryImpl: ReqresRepositoryImpl): ReqresRepository
}
