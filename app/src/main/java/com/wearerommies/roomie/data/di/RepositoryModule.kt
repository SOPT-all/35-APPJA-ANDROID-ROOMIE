package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.repositoryimpl.UserRepositoryImpl
import com.wearerommies.roomie.data.repositoryimpl.HouseRepositoryImpl
import com.wearerommies.roomie.data.repositoryimpl.ReqresRepositoryImpl
import com.wearerommies.roomie.domain.repository.UserRepository
import com.wearerommies.roomie.domain.repository.HouseRepository
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
    fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    fun bindsHouseRepository(houseRepositoryImpl: HouseRepositoryImpl): HouseRepository
}
