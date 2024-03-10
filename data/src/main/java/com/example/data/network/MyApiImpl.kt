package com.example.data.network

import com.apollographql.apollo3.ApolloClient
import com.data.RocketsQuery
import com.example.domain.model.Rocket

class MyApiImpl(
    private val apolloClient: ApolloClient
) : MyApi {
    override suspend fun fetchRockets(): List<Rocket> {
        val response = apolloClient.query(RocketsQuery()).execute()

        return response.data?.rockets?.mapNotNull { it?.asRocket() } ?: emptyList()
    }
}


fun RocketsQuery.Rocket.asRocket(): Rocket {
    return Rocket(
        id = this.id ?: "",
        name = this.name ?: "",
        description = this.description ?: ""
    )
}