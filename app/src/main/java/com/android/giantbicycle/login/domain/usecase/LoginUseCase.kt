package com.android.giantbicycle.login.domain.usecase

import com.android.giantbicycle.login.domain.repository.LoginRepository
import com.android.shared.domain.usecase.AsyncUseCase
import io.reactivex.Single

class LoginUseCase(
    private val repository: LoginRepository,
) : AsyncUseCase<LoginUseCaseModel, Single<LoginUseCaseResult>> {

    override fun execute(param: LoginUseCaseModel): Single<LoginUseCaseResult> {
        return repository.login(
            username = param.username!!,
            password = param.password!!,
        ).map {
            LoginUseCaseResult(
                result = it.result,
                error = it.error?.name
            )
        }
    }
}

data class LoginUseCaseModel(
    val username: String?,
    val password: String?,
)

data class LoginUseCaseResult(
    val result: Int? = null,
    val error: String? = null
)