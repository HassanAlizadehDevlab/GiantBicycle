package com.android.giantbicycle.login.data.datasource

import com.android.giantbicycle.login.data.network.ApiService
import com.android.shared.data.error.ApiResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class LoginRemoteDataSourceImpl @Inject constructor(
    private val service: ApiService
) : LoginRemoteDataSource {

    override fun loginWithDelay(username: String, password: String): Single<ApiResponse<Int?>> {
        return Single.fromCallable {
            service.login(
                username = username,
                password = password
            )
        }.delay(5, TimeUnit.SECONDS)
    }

    override fun login(username: String, password: String): Single<ApiResponse<Int?>> {
        return Single.fromCallable {
            service.login(
                username = username,
                password = password
            )
        }
    }
}