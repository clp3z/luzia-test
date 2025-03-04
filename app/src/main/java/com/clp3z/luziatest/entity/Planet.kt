package com.clp3z.luziatest.entity

import kotlinx.serialization.Serializable

@Serializable
data class Planet(
    val name: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val population: String,
    val url: String
)
