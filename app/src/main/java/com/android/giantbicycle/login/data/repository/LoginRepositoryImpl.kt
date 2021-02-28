package com.android.giantbicycle.login.data.repository

import com.android.giantbicycle.login.data.datasource.LoginRemoteDataSource
import com.android.giantbicycle.login.domain.repository.LoginRepository
import com.android.shared.data.error.ApiResponse
import io.reactivex.Single

class LoginRepositoryImpl(
    private val dataSource: LoginRemoteDataSource
) : LoginRepository {

    override fun login(username: String, password: String): Single<ApiResponse<Int?>> {
        return dataSource.login(
            username = username,
            password = password
        )
    }
}