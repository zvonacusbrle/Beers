package com.example.domain.usecase


import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.example.domain.model.Rocket

import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetRockets {
    suspend fun execute(param: Any): ApolloCall<Rocket>
}

 interface GetRocketsUseCase: GetRockets {
    override suspend fun execute(param: Any): ApolloCall<Rocket>
}
