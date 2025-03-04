package com.clp3z.luziatest.entity

sealed interface Error {
    class Server(val code: Int, val message: String) : Error
    class Unknown(val message: String) : Error
}
