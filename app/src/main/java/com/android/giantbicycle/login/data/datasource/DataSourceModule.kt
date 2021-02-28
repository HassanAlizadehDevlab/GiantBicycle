package com.android.giantbicycle.login.data.datasource

import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class DataSourceModule {
    @Binds
    @Reusable
    abstract fun provideRemoteLoginDataSource(
        remoteLoginRemoteDataSourceImpl: LoginRemoteDataSourceImpl
    ): LoginRemoteDataSource
}