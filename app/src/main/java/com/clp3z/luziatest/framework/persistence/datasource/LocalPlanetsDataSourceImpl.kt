package com.clp3z.luziatest.framework.persistence.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.clp3z.luziatest.common.tryCall
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.toError
import com.clp3z.luziatest.framework.persistence.dao.PlanetsDAO
import com.clp3z.luziatest.framework.persistence.toLocalPlanet
import com.clp3z.luziatest.framework.persistence.toPlanet
import com.clp3z.luziatest.framework.persistence.toPlanets
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalPlanetsDataSourceImpl @Inject constructor(
    private val planetsDAO: PlanetsDAO
) : LocalPlanetsDataSource {

    override fun getPlanets(): Flow<List<Planet>> = planetsDAO
        .getPlanets()
        .map { it.toPlanets() }

    override fun getPlanet(id: Int): Flow<Planet> = planetsDAO
        .getPlanet(id)
        .map { it.toPlanet() }

    override suspend fun insertPlanets(planets: List<Planet>): Either<Error, Boolean> = tryCall (
        execute = {
            planetsDAO.insertPlanets(
                planets.map { it.toLocalPlanet() }
            )
        },
        toError = {
            it.toError()
        }
    ).fold(
        ifLeft = { it.left() },
        ifRight = { true.right() },
    )

    override suspend fun isEmpty(): Boolean = planetsDAO.planetsCount() == 0
}
