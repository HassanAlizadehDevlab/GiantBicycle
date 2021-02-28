package com.android.giantbicycle.login.data.network

import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class NetworkModule {
    @Binds
    @Reusable
    abstract fun provideLoginApiService(
        apiServiceImpl: ApiServiceImpl
    ): ApiService
}