package com.android.shared.domain.string

import android.content.Context
import com.android.giantbicycle.R
import com.android.shared.data.error.Error


class StringBuilderImpl (
    private val context: Context
) : StringBuilder {
    override fun usernameIsNull(): String = context.getString(R.string.username_is_null)
    override fun passwordIsNull(): String = context.getString(R.string.password_is_null)
    override fun wrongCredential(): String = context.getString(R.string.wrong_credential)
    override fun internalServerError(): String = context.getString(R.string.internal_server_error)
    override fun unknownError(): String = context.getString(R.string.unknown_error)

    override fun getMessageByError(error: Error?): String? {
        error ?: return null

        return when (error) {
            Error.WRONG_CREDENTIALS -> wrongCredential()
            Error.INTERNAL_SERVER_ERROR -> internalServerError()
            else -> unknownError()
        }
    }
}