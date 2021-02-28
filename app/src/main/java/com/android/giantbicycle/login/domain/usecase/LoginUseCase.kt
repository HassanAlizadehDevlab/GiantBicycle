package com.android.giantbicycle.login.domain.usecase

import com.android.giantbicycle.login.domain.repository.LoginRepository
import com.android.shared.domain.string.StringBuilder
import com.android.shared.domain.usecase.AsyncUseCase
import com.android.shared.domain.usecase.transformer.STransformer
import io.reactivex.Single
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val repository: LoginRepository,
    private val stringBuilder: StringBuilder,
    private val transformer: STransformer<LoginUseCaseResult>,
) : AsyncUseCase<LoginUseCaseModel, Single<LoginUseCaseResult>> {

    override fun execute(param: LoginUseCaseModel): Single<LoginUseCaseResult> {
        if (param.username.isNullOrEmpty())
            return Single.just(LoginUseCaseResult(error = stringBuilder.usernameIsNull()))
        if (param.password.isNullOrEmpty())
            return Single.just(LoginUseCaseResult(error = stringBuilder.passwordIsNull()))

        return repository.login(
            username = param.username,
            password = param.password,
        ).map {
            LoginUseCaseResult(
                result = it.result,
                error = stringBuilder.getMessageByError(it.error)
            )
        }.compose(transformer)
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