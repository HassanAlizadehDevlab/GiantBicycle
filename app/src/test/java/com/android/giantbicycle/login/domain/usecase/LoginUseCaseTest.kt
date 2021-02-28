package com.android.giantbicycle.login.domain.usecase

import com.android.giantbicycle.login.domain.repository.LoginRepository
import com.android.shared.data.error.ApiResponse
import com.android.shared.domain.string.StringBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginUseCaseTest {

    private val repository: LoginRepository = mockk()
    private val stringBuilder: StringBuilder = mockk()
    private val usecase: LoginUseCase = LoginUseCase(repository, stringBuilder)


    @Test
    fun `login user - success`() {
        val username = "user"
        val password = "password"
        val request = LoginUseCaseModel(username, password)
        val expected = LoginUseCaseResult(result = 1, error = null)
        every { repository.login(any(), any()) } returns Single.just(
            ApiResponse(
                result = 1,
                error = null
            )
        )
        every { stringBuilder.getMessageByError(null) } returns null

        usecase.execute(request)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(expected)

        verify { repository.login(username, password) }
    }


    @Test
    fun `login user with empty or null username - error`() {
        val username = null
        val password = "password"
        val request = LoginUseCaseModel(username, password)
        val expectedError = "Please fill the username field"
        val expectedResult = LoginUseCaseResult(result = null, error = expectedError)
        every { repository.login(any(), any()) } returns Single.just(
            ApiResponse(
                result = null,
                error = null
            )
        )
        every { stringBuilder.usernameIsNull() } returns expectedError


        usecase.execute(request)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(expectedResult)


        verify(exactly = 0) { repository.login(any(), any()) }
    }

    @Test
    fun `login user with empty or null password - error`() {
        val username = "username"
        val password = null
        val request = LoginUseCaseModel(username, password)
        val expectedError = "Please fill the password field"
        val expected = LoginUseCaseResult(result = null, error = expectedError)
        every { repository.login(any(), any()) } returns Single.just(
            ApiResponse(
                result = null,
                error = null
            )
        )
        every { stringBuilder.passwordIsNull() } returns expectedError


        usecase.execute(request)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(expected)

        verify(exactly = 0) { repository.login(any(), any()) }
    }

}