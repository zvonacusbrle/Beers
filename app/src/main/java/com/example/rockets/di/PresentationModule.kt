package com.example.rockets.di

import com.example.rockets.RocketListConverter
import com.example.rockets.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single { RocketListConverter() }
    viewModel { ViewModel(get(), get()) }
}