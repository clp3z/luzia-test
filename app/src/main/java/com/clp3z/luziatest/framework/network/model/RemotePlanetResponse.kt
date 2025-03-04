package com.clp3z.luziatest.framework.network.model

import com.clp3z.luziatest.framework.network.model.RemotePlanet
import kotlinx.serialization.Serializable

@Serializable
data class RemotePlanetResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<RemotePlanet>
)
