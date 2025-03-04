package com.clp3z.luziatest.framework.persistence.datasource

import arrow.core.Either
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import kotlinx.coroutines.flow.Flow

interface LocalPlanetsDataSource {

    fun getPlanets(): Flow<List<Planet>>

    fun getPlanet(id: Int): Flow<Planet>

    suspend fun insertPlanets(planets: List<Planet>): Either<Error, Boolean>

    suspend fun isEmpty(): Boolean
}
