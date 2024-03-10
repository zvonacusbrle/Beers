package com.example.data.network

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.data.RocketsQuery
import com.example.domain.model.Rocket

interface MyApi {
    suspend fun fetchRockets(): List<Rocket>
}