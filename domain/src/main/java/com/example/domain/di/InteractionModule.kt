package com.example.domain.di

import com.example.domain.Entity.UseCase
import com.example.domain.repository.RocketsRepository
import com.example.domain.usecase.GetRocketsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val interactionModule = module {
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    single { dispatcher }
    single { UseCase.Configuration(get()) }
    factory {GetRocketsUseCase(get(), get())}

}