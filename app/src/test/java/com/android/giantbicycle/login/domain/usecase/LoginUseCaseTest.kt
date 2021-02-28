package com.android.giantbicycle.login.domain.usecase

import com.android.giantbicycle.login.domain.repository.LoginRepository
import com.android.shared.data.error.ApiResponse
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
    private val usecase: LoginUseCase = LoginUseCase(repository)


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

        usecase.execute(request)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue(expected)

        verify { repository.login(username, password) }
    }

}