package com.android.shared.domain.string

import com.android.shared.data.error.Error

/**
 * An interface to get proper message from string resources in usecases
 * */
interface StringBuilder {
    fun usernameIsNull(): String
    fun passwordIsNull(): String
    fun wrongCredential(): String
    fun internalServerError(): String
    fun unknownError(): String

    fun getMessageByError(error: Error?): String?
}