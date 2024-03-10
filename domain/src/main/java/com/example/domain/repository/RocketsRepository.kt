package com.example.domain.repository

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation
import com.example.domain.model.Rocket


interface RocketsRepository{
    suspend fun rocketsQuery() : ApolloCall<Rocket>
}