package com.example.data.repository

import com.apollographql.apollo3.ApolloClient
import com.data.RocketsQuery
import com.example.domain.Entity.Rocket
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RocketsRepositoryImpl(
    private val apolloClient: ApolloClient
) : RocketsRepository {
    override suspend fun getRockets(): Flow<List<Rocket>> = flow{
        val response = apolloClient.query(RocketsQuery()).execute()
        val rockets = response.data?.rockets?.mapNotNull {rocket ->
            rocket?.asRocket()
        } ?: emptyList()

        emit(rockets)
    }


}

fun RocketsQuery.Rocket.asRocket(): Rocket {
    return Rocket(
        id = this.id ?: "",
        name = this.name ?: "",
        description = this.description ?: ""
    )
}