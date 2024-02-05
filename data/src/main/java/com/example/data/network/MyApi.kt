package com.example.data.network

import com.apollographql.apollo3.ApolloCall
import com.data.RocketsQuery

interface MyApi {
    suspend fun fetchRockets(): ApolloCall<RocketsQuery.Data>
}