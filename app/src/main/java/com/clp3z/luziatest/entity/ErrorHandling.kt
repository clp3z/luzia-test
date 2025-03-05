package com.clp3z.luziatest.entity

import retrofit2.HttpException

fun Throwable.toError(): Error = when (this) {
    is HttpException -> Error.Server(code(), message() ?: stackTraceToString())
    else -> Error.Unknown(message ?: stackTraceToString())
}
