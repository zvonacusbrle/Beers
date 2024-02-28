package com.example.domain.usecase


import com.apollographql.apollo3.ApolloCall
import com.data.RocketsQuery
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getRocketsUseCase(rocketsRepository: RocketsRepository,
                              dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApolloCall<RocketsQuery.Data> {

    return withContext(dispatcher){
        rocketsRepository.rocketsQuery()
    }
}