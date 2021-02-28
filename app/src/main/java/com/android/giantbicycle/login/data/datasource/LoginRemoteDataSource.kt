package com.android.giantbicycle.login.data.datasource

import com.android.shared.data.error.ApiResponse
import io.reactivex.Single

interface LoginRemoteDataSource {
    fun login(
        username: String,
        password: String,
    ): Single<ApiResponse<Int?>>
}