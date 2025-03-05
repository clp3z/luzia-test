package com.clp3z.luziatest.framework.network.service

import com.clp3z.luziatest.framework.network.model.RemotePlanet
import com.clp3z.luziatest.framework.network.model.RemotePlanetResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PlanetsService {

    @GET("/api/planets/")
    suspend fun getPlanets(@Query("page") page: Int): RemotePlanetResponse

    @GET
    suspend fun getPlanetFromUrl(@Url url: String): RemotePlanet
}
