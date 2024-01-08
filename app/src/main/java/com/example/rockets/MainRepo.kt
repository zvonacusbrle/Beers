package com.example.rockets

import com.apollographql.apollo3.ApolloClient
import com.example.RocketsQuery
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class MainRepo @Inject constructor(private val apolloClient: ApolloClient) {

    suspend fun getRockets() =
        apolloClient.query(RocketsQuery()).execute()
}