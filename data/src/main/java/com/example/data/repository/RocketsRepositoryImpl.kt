package com.example.data.repository

import com.apollographql.apollo3.ApolloCall

import com.data.RocketsQuery
import com.example.data.network.MyApi
import com.example.domain.repository.RocketsRepository


class RocketsRepositoryImpl(
    private val myApi: MyApi
) : RocketsRepository {
    override suspend fun rocketsQuery(): ApolloCall<RocketsQuery.Rocket> {
        return myApi.fetchRockets()
    }
}