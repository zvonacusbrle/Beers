package com.example.rockets

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setupObserver()
        }
        // setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            mainViewModel.getRockets().observe(this@MainActivity) {
                when (it) {
                    is Resource.Loading -> {
                        Log.d(TAG, "Loading - Called")
                    }
                    is Resource.Success -> {
                        Log.d(TAG, "Success - Called ${it.data}")
                        // Toast.makeText(this@MainActivity, "${it.data}", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Error -> {
                        Log.d(TAG, "Error - Called $it")
                        // Handle error case
                    }

                    else -> {}
                }
            }
        }
    }
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null, message: String) : Resource<T>(data, message)
}