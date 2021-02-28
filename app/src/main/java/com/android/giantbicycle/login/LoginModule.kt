package com.android.giantbicycle.login

import com.android.giantbicycle.login.data.DataModule
import com.android.giantbicycle.login.domain.DomainModule
import com.android.giantbicycle.login.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class,
    ]
)
abstract class LoginModule