package com.android.giantbicycle

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Project dagger component.
 */
@Singleton
@Component(
    modules = [
        GiantBicycleModule::class,
    ]
)
interface GiantBicycleComponent : AndroidInjector<GiantBicycleApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GiantBicycleApplication): GiantBicycleComponent
    }

}