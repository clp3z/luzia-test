package com.clp3z.luziatest.framework.network.datasource

import arrow.core.Either
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.service.PlanetsService
import com.clp3z.luziatest.entity.toError
import com.clp3z.luziatest.framework.network.toPlanet
import com.clp3z.luziatest.common.tryCall
import com.clp3z.luziatest.framework.network.toId

import javax.inject.Inject

internal class RemotePlanetsDataSourceImpl @Inject constructor(
    private val planetsService: PlanetsService
) : RemotePlanetsDataSource {

    override suspend fun getPlanets(page: Int): Either<Error, List<Planet>> =
        tryCall(
            execute = {
                planetsService
                    .getPlanets(page)
                    .results
                    .map { it.toPlanet() }
            },
            toError = {
                it.toError()
            }
        )

    override suspend fun getPlanet(url: String): Either<Error, Planet> =
        tryCall(
            execute = {
                planetsService
                    .getPlanetFromUrl(url)
                    .toPlanet()
            },
            toError = {
                it.toError()
            }
        )
}
