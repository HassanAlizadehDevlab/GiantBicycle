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

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing


    fun login(username: String?, password: String?) {
        _isRefreshing.value = true

        loginUseCase.execute(LoginUseCaseModel(username, password))
            .doOnEvent { _, _ -> _isRefreshing.value = false }
            .subscribe(::loginResultConsumer)
            .track()
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