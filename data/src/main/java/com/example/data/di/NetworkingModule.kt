package com.example.data.di

import com.apollographql.apollo3.ApolloClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {

    single {
        ApolloClient.Builder()
            .serverUrl("https://spacex-production.up.railway.app/")
            .build()
    }

}

