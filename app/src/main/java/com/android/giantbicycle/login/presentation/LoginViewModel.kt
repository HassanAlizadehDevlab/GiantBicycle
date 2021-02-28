package com.android.giantbicycle.login.presentation

import androidx.lifecycle.ViewModel
import com.android.giantbicycle.login.domain.usecase.LoginUseCase
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseModel
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseResult

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun login(username: String?, password: String?) {
        loginUseCase.execute(LoginUseCaseModel(username, password))
            .subscribe(::loginResultConsumer)
    }

    private fun loginResultConsumer(loginResult: LoginUseCaseResult) {}

}