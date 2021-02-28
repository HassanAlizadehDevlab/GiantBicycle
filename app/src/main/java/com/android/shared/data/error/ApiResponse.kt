package com.android.shared.data.error

/**
 *  Represents a response from the API
 *  */
data class ApiResponse<T>(
    val result: T?,
    val error: Error?
)