package com.example.repository

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.data.RocketsQuery
import com.example.data.network.MyApi
import com.example.domain.repository.RocketsRepository


class RocketsRepositoryImpl(
    private val myApi: MyApi
) : RocketsRepository {
    override suspend fun rocketsQuery(): ApolloCall<Operation.Data> {
        return myApi.fetchRockets()
    }
}