package com.wearerommies.roomie.data.di

import com.wearerommies.roomie.data.datasource.ReqresDataSource
import com.wearerommies.roomie.data.datasourceimpl.ReqresDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsReqresDataSource(reqresDataSourceImpl: ReqresDataSourceImpl): ReqresDataSource
}
