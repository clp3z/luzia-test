package com.clp3z.luziatest.common

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.clp3z.luziatest.entity.Error

suspend fun <T> tryCall(
    execute: suspend () -> T,
    toError: (Throwable) -> Error
): Either<Error, T> =
    try {
        execute().right()
    } catch (throwable: Throwable) {
        toError(throwable).left()
    }
