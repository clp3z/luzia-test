package com.clp3z.luziatest.app.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination {

    @Serializable
    data object Main : Destination

    @Serializable
    data class Detail(val url: String) : Destination
}
