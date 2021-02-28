package com.android.giantbicycle.login.data.repository

import com.android.giantbicycle.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
abstract class RepositoryModule {
    @Binds
    @Reusable
    abstract fun provideLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository
}