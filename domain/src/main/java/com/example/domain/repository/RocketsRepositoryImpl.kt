package com.example.domain.repository

import com.apollographql.apollo3.ApolloCall
import com.data.RocketsQuery
import com.example.data.network.MyApi


class RocketsRepositoryImpl(
    private val myApi: MyApi
) : RocketsRepository {
    override suspend fun rocketsQuery(): ApolloCall<RocketsQuery.Data> {
        return myApi.fetchRockets()
    }
}