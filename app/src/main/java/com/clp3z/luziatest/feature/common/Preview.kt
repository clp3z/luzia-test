package com.clp3z.luziatest.feature.common

import com.clp3z.luziatest.entity.Planet

val previewPlanet = Planet(
    name = "Mandalore",
    diameter = "9200",
    climate = "temperate",
    gravity = "1 standard",
    terrain = "forests, deserts, plains, cities",
    population = "4000000",
    url = "https://swapi.dev/api/planets/13/"
)

val previewPlanets = mutableListOf<Planet>().apply {
    repeat(10) { add(previewPlanet.copy(url = "https://swapi.dev/api/planets/$it/")) }
}
