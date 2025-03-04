package com.clp3z.luziatest.framework.persistence.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalPlanet(
    @PrimaryKey val id: String,
    val name: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val population: String,
    val url: String
)
