package com.android.giantbicycle

import android.app.Application
import com.android.giantbicycle.login.LoginModule
import com.android.giantbicycle.login.presentation.LoginActivity
import com.android.shared.di.scope.ActivityScope
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
abstract class GiantBicycleModule {

    @Binds
    @Singleton
    abstract fun application(application: GiantBicycleApplication): Application

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginActivityInjector(): LoginActivity

}