package com.android.giantbicycle.login.data.datasource

import com.android.shared.data.error.ApiResponse
import io.reactivex.Single

interface LoginRemoteDataSource {

    /**
     * Login with 5 seconds delay
     * */
    fun loginWithDelay(
        username: String,
        password: String,
    ): Single<ApiResponse<Int?>>

    fun login(
        username: String,
        password: String,
    ): Single<ApiResponse<Int?>>
}