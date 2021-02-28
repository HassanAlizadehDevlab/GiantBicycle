package com.android.giantbicycle.login.data.network

import com.android.shared.data.error.ApiResponse

/**
 * This interface and method will simulate the login endpoint
 * */
interface ApiService {
    fun login(username: String, password: String): ApiResponse<Int?>
}