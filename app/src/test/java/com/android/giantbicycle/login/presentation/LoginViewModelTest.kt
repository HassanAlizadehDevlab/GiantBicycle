package com.android.giantbicycle.login.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.giantbicycle.login.domain.usecase.LoginUseCase
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseModel
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseResult
import com.android.shared.utils.observeOnce
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val loginUseCase: LoginUseCase = mockk()
    private val viewModel: LoginViewModel = LoginViewModel(loginUseCase)


    @Test
    fun `check login usecase called`() {
        val username = "user"
        val password = "password"
        every { loginUseCase.execute(any()) } returns Single.just(LoginUseCaseResult(result = 1))


        viewModel.login(username, password)


        verify {
            loginUseCase.execute(withArg {
                with(this.actual as LoginUseCaseModel) {
                    assert(this.username == username)
                    assert(this.password == password)
                }
            })
        }
    }

    @Test
    fun `check response is set when result is success`() {
        val username = "user"
        val password = "password"
        val expected = 1
        val responseObserver: (Int) -> Unit = mockk()
        viewModel.response.observeOnce(responseObserver)
        every { responseObserver.invoke(any()) } returns Unit
        every { loginUseCase.execute(any()) } returns Single.just(LoginUseCaseResult(result = expected))


        viewModel.login(username, password)


        verify { responseObserver.invoke(expected) }
    }

    @Test
    fun `show error message when is username null`() {
        val username = null
        val password = "password"
        val expectedError = "Please fill the username field"
        val messageObserver: (String) -> Unit = mockk()
        viewModel.messageObservable.observeOnce(messageObserver)
        every { messageObserver.invoke(any()) } returns Unit
        every { loginUseCase.execute(any()) } returns Single.just(LoginUseCaseResult(error = expectedError))


        viewModel.login(username, password)


        verify { messageObserver.invoke(expectedError) }
    }

}