package com.clp3z.luziatest.framework.persistence

import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.model.RemotePlanet
import com.clp3z.luziatest.framework.persistence.model.LocalPlanet

fun Planet.toLocalPlanet() = LocalPlanet(
    id = url.toId(),
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    url = url
)

fun LocalPlanet.toPlanet() = Planet(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    url = url
)

fun List<LocalPlanet>.toPlanets() = map { it.toPlanet() }

// TODO: complete the transformation from URI
fun String.toId() = ""
