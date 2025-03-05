package com.clp3z.luziatest.framework.persistence

import arrow.core.Either
import com.clp3z.luziatest.entity.Error

fun <T> T.rightWithError(): Either<Error, T> = Either.Right(this)