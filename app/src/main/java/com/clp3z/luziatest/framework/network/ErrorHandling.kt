package com.clp3z.luziatest.framework.network

import com.clp3z.luziatest.entity.Error
import retrofit2.HttpException

fun Throwable.toError() = when (this) {
    is HttpException -> Error.Server(code(), message() ?: stackTraceToString())
    else -> Error.Unknown(message ?: stackTraceToString())
}
