package com.clp3z.luziatest.data

import arrow.core.Either
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.datasource.RemotePlanetsDataSource
import com.clp3z.luziatest.framework.network.toId
import javax.inject.Inject

class PlanetsRepository @Inject constructor(
    private val remotePlanetsDataSource: RemotePlanetsDataSource
) {

    suspend fun getPlanets(page: Int): Either<Error, List<Planet>> =
        remotePlanetsDataSource.getPlanets(page)

    suspend fun getPlanet(url: String): Either<Error, Planet> =
        remotePlanetsDataSource.getPlanet(url.toId())
}
