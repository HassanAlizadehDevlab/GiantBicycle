package com.android.giantbicycle.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.giantbicycle.login.domain.usecase.LoginUseCase
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseModel
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseResult
import com.android.shared.presentation.BaseViewModel

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _response = MutableLiveData<Int>()
    val response: LiveData<Int>
        get() = _response

    fun login(username: String?, password: String?) {
        loginUseCase.execute(LoginUseCaseModel(username, password))
            .subscribe(::loginResultConsumer)
    }

    private fun loginResultConsumer(loginResult: LoginUseCaseResult) {
        loginResult.result?.let {
            _response.value = it
        }
        loginResult.error?.let {
            _messageObservable.value = it
        }
    }

}