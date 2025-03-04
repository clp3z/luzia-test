package com.clp3z.luziatest.framework.network

import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.model.RemotePlanet

fun RemotePlanet.toPlanet() = Planet(
    name = name,
    diameter = diameter,
    climate = climate,
    gravity = gravity,
    terrain = terrain,
    population = population,
    url = url
)
