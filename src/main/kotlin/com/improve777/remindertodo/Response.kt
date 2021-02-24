package com.improve777.remindertodo

data class BaseResponse<T>(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: T?,
    val error: String,
) {

    companion object {
        fun <T> ok(code: Int = 200, message: String, data: T? = null) = BaseResponse(
            success = true,
            code = code,
            message = message,
            data = data,
            error = "",
        )

        fun error(code: Int, message: String, error: String) = BaseResponse<String>(
            success = false,
            code = code,
            message = message,
            data = null,
            error = error,
        )
    }
}
