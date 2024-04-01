package com.example.rockets

import android.util.Log
import com.example.rockets.state.UiState
import com.example.domain.Entity.Result
import timber.log.Timber
import java.util.logging.Logger

abstract class CommonResultConverter<T : Any, R : Any> {

    fun convert(result: Result<T>): UiState<R> {
        return when (result) {
            is Result.Error -> {
                UiState.Error(result.exception.localizedMessage.orEmpty())
            }
            is Result.Success -> {
                UiState.Success(convertSuccess(result.data))
            }
        }
    }

    abstract fun convertSuccess(data: T): R
}