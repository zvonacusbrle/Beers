package com.example.domain.repository

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.example.domain.model.Rocket
import kotlinx.coroutines.flow.Flow


interface RocketsRepository{
    suspend fun fetchRockets() : Flow<List<Rocket>?>
}