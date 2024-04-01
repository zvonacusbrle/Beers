package com.example.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Entity.Rocket
import com.example.domain.repository.RocketsRepository
import com.example.domain.usecase.GetRocketsUseCase
import com.example.rockets.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ViewModel(
    private val rocketsUseCase: GetRocketsUseCase

) : ViewModel() {

    private val _rocketsStateFlow =
        MutableStateFlow<UiState<List<Rocket>>>(UiState.Loading)
    val rocketListFlow: StateFlow<UiState<List<Rocket>>> = _rocketsStateFlow

    fun loadRockets(){
        viewModelScope.launch {
            rocketsUseCase.execute(GetRocketsUseCase.Request)
                .map {

                }

                .collect{
                    _rocketsStateFlow.value = it
                }
        }
    }
}