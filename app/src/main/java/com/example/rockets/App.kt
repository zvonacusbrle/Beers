package com.example.rockets

import android.app.Application
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.domain.di.interactionModule
import com.example.rockets.di.presentationModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    presentationModule,
                    interactionModule
                )
            )
        }
    }
}