package com.android.giantbicycle.login.data

import com.android.giantbicycle.login.data.datasource.DataSourceModule
import com.android.giantbicycle.login.data.network.NetworkModule
import com.android.giantbicycle.login.data.repository.RepositoryModule
import dagger.Module

@Module(
    includes = [
        DataSourceModule::class,
        RepositoryModule::class,
        NetworkModule::class,
    ]
)
abstract class DataModule