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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

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
                    Timber.tag("MainActivity").d("Loading  ")
                    Text("Loading")
                }
                is UiState.Success -> {
                    val rockets = uiState.data
                    Timber.tag("MainActivity").d("onCreate: SUCESS  ")
                    Timber.tag("MainActivity").d("data: $rockets  ")
                    Text("Rockets: $rockets")
                }
                is UiState.Error -> {
                    Timber.tag("MainActivity").d("onCreate: ERROR  ")
                    Text("Error")
                }
            }
            // val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        }
    }
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null, message: String) : Resource<T>(data, message)
}