package com.example.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.data.network.MyApi
import com.example.domain.repository.RocketsRepository
import com.example.data.repository.RocketsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single {  RocketsRepositoryImpl(get()) as RocketsRepository }
}