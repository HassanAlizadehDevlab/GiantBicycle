package com.android.giantbicycle.login.domain

import com.android.giantbicycle.login.domain.usecase.LoginUseCaseResult
import com.android.shared.domain.usecase.transformer.AsyncSTransformer
import com.android.shared.domain.usecase.transformer.STransformer
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun loginTransformer(): STransformer<LoginUseCaseResult> {
        return AsyncSTransformer()
    }

}