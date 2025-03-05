package com.clp3z.luziatest.data

import arrow.core.Either
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.framework.network.datasource.RemotePlanetsDataSource
import com.clp3z.luziatest.framework.network.toId
import com.clp3z.luziatest.framework.persistence.datasource.LocalPlanetsDataSource
import com.clp3z.luziatest.framework.persistence.rightWithError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlanetsRepository @Inject constructor(
    private val remotePlanetsDataSource: RemotePlanetsDataSource,
    private val localPlanetsDataSource: LocalPlanetsDataSource
) {

    val planets: Flow<List<Planet>> = localPlanetsDataSource.getPlanets()

    fun getPlanets(page: Int): Flow<Either<Error, List<Planet>>> = flow {
        if (localPlanetsDataSource.isEmpty()) {
            val remoteResult = remotePlanetsDataSource.getPlanets(page)
            emit(remoteResult)
            if (remoteResult is Either.Right) {
                localPlanetsDataSource.insertPlanets(remoteResult.value)
            }
        } else {
            emitAll(localPlanetsDataSource.getPlanets().map { it.rightWithError() })
        }
    }

    fun getPlanet(url: String): Flow<Either<Error, Planet>> =
        localPlanetsDataSource.getPlanet(url)
            .map { it.rightWithError() }
            .catch { emit(remotePlanetsDataSource.getPlanet(url.toId())) }
}
