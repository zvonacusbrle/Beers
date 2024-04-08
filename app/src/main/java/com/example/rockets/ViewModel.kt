package com.example.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Entity.RocketsList
import com.example.domain.usecase.GetRocketsUseCase
import com.example.rockets.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ViewModel(
    private val rocketsUseCase: GetRocketsUseCase,
    private val converter: RocketListConverter
) : ViewModel() {

    private val _rocketsStateFlow =
        MutableStateFlow<UiState<RocketsList>>(UiState.Loading)
    val rocketListFlow: StateFlow<UiState<RocketsList>> = _rocketsStateFlow

    fun loadRockets() {
        viewModelScope.launch {
            rocketsUseCase.execute(GetRocketsUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    _rocketsStateFlow.value = it
                }
        }
    }
}