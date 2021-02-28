package com.android.giantbicycle.login.domain.repository

import com.android.shared.data.error.ApiResponse
import io.reactivex.Single

interface LoginRepository {
    fun login(username: String, password: String): Single<ApiResponse<Int?>>
}