package com.example.domain.repository

import com.apollographql.apollo3.ApolloCall
import com.data.RocketsQuery


interface RocketsRepository{
    suspend fun rocketsQuery() : ApolloCall<RocketsQuery.Data>
}