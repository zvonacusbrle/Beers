package com.example.domain.usecase


import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation

import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetRockets {
    suspend fun invoke(param: Any): ApolloCall<Operation.Data>
}

 interface GetRocketsUseCase: GetRockets {
    override suspend fun invoke(param: Any): ApolloCall<Operation.Data>
}
