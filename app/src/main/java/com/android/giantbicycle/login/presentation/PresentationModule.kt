package com.android.giantbicycle.login.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.android.shared.di.scope.ActivityScope
import com.android.shared.di.scope.ViewModelKey
import com.android.shared.domain.string.StringBuilderImpl
import com.android.shared.domain.string.StringBuilder
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @ActivityScope
    abstract fun loginContext(loginActivity: LoginActivity): Context

    @Binds
    @ActivityScope
    abstract fun loginStringBuilder(stringBuilderImpl: StringBuilderImpl): StringBuilder

}