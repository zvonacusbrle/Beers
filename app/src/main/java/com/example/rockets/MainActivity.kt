package com.example.rockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.rockets.state.UiState
import com.google.accompanist.adaptive.calculateDisplayFeatures
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.perf.FirebasePerformance
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : ComponentActivity() {
    private val viewModel: ViewModel by inject()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        FirebasePerformance.getInstance().isPerformanceCollectionEnabled = true

        setContent {
            val windowSize = calculateWindowSizeClass(this)
            val displayFeatures = calculateDisplayFeatures(this)
            viewModel.loadRockets()
            val state = viewModel.rocketListFlow.collectAsState().value

            when (val uiState = state) {
                is UiState.Loading -> {
                    Timber.tag("TAG").d("Loading  ")
                    Text("Loading")
                }
                is UiState.Success -> {
                    val rockets = uiState.data
                    Timber.tag("TAG").d("onCreate: SUCESS  ")
                    Timber.tag("TAG").d("data: $rockets  ")
                    Text("Rockets: $rockets")
                }
                is UiState.Error -> {
                    Timber.tag("TAG").d("onCreate: ERROR  ")
                    Text("Error")
                }
            }
        }
    }
}
