package com.example.domain.repository

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.api.Operation


interface RocketsRepository{
    suspend fun rocketsQuery() : ApolloCall<Operation.Data>
}