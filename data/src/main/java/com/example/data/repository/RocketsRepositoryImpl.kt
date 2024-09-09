package com.example.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.data.RocketsQuery
import com.example.domain.Entity.Rocket
import com.example.domain.Entity.RocketsList
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RocketsRepositoryImpl(
    private val apolloClient: ApolloClient
) : RocketsRepository {
    override suspend fun getRockets(): Flow<RocketsList> = flow {
        val response = apolloClient.query(RocketsQuery()).execute()
        val rockets = response.data?.rockets?.mapNotNull { rocket ->
            rocket?.asRockets()
        }
        emit(RocketsList(rockets ?: emptyList()))
    }
}

fun RocketsQuery.Rocket.asRockets(): Rocket {
    return Rocket(
        id = this.id ?: "",
        name = this.name ?: "",
        description = this.description ?: ""
    )
}
