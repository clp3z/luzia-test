package com.clp3z.luziatest.domain

import arrow.core.Either
import com.clp3z.luziatest.data.PlanetsRepository
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val planetsRepository: PlanetsRepository
) {

    suspend operator fun invoke(page: Int): Either<Error, List<Planet>> =
        planetsRepository.getPlanets(page)
}
