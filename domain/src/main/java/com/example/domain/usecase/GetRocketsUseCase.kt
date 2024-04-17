package com.example.domain.usecase

import com.example.domain.Entity.Rocket
import com.example.domain.Entity.RocketsList
import com.example.domain.Entity.UseCase
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class GetRocketsUseCase(
    configuration: Configuration,
    private val rocketsRepository: RocketsRepository,
) : UseCase<GetRocketsUseCase.Request, GetRocketsUseCase.Response>(configuration) {

    override suspend fun process(request: Request): Flow<Response> =
        rocketsRepository.getRockets().mapNotNull {
            Response(it)
        }


    object Request : UseCase.Request
    data class Response(val rockets: RocketsList) : UseCase.Response


}