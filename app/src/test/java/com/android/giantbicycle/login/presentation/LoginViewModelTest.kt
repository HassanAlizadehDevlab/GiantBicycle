package com.android.giantbicycle.login.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.giantbicycle.login.domain.usecase.LoginUseCase
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseModel
import com.android.giantbicycle.login.domain.usecase.LoginUseCaseResult
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
    fun `show error message when is username null`() {
        val username = null
        val password = "password"
        val expectedError = "Please fill the username field"
        every { loginUseCase.execute(any()) } returns Single.just(LoginUseCaseResult(error = expectedError))


        viewModel.login(username, password)


        verify {
            loginUseCase.execute(withArg {
                with(this.actual as LoginUseCaseModel) {
                    assert(this.username == null)
                    assert(this.password == password)
                }
            })
        }
    }

}