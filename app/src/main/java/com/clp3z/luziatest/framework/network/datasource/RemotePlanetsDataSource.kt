package com.clp3z.luziatest.framework.network.datasource

import arrow.core.Either
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet

interface RemotePlanetsDataSource {

    suspend fun getPlanets(page: Int): Either<Error, List<Planet>>

    suspend fun getPlanet(url: String): Either<Error, Planet>
}
