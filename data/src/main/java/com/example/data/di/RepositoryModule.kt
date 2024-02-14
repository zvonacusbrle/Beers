package com.example.data.di

import com.apollographql.apollo3.ApolloClient
import com.example.domain.repository.RocketsRepository
import com.example.repository.RocketsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single {  RocketsRepositoryImpl(get()) as RocketsRepository }
}