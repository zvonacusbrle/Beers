package com.example.rockets.state

sealed class UiState<out T : Any> {
    data class Error(val errorMessage: String) : UiState<Nothing>()
    data class Success<T : Any>(val data: T) : UiState<T>()

    object Loading : UiState<Nothing>()
}