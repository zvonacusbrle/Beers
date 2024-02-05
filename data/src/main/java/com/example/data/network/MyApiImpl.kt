package com.example.data.network

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.data.RocketsQuery

class MyApiImpl(
    private val apolloClient: ApolloClient
) : MyApi {
    override suspend fun fetchRockets(): ApolloCall<RocketsQuery.Data> {
        return apolloClient.query(RocketsQuery())
    }
}