package com.clp3z.luziatest.domain

import arrow.core.Either
import com.clp3z.luziatest.data.PlanetsRepository
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import javax.inject.Inject

class GetPlanetUseCase @Inject constructor(
    private val repository: PlanetsRepository
) {

    suspend operator fun invoke(url: String): Either<Error, Planet> = repository.getPlanet(url)
}
