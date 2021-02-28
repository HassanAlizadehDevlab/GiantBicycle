package com.android.giantbicycle

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins


class GiantBicycleApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerGiantBicycleComponent.factory().create(this)


    override fun onCreate() {
        super.onCreate()
        initRxErrorHandler()
    }

    /**
     * RxJavaPlugins.setErrorHandler used for handle rx errors like network errors
     * */
    private fun initRxErrorHandler() {
        RxJavaPlugins.setErrorHandler {}
    }
}