package com.example.rockets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val repository: RocketsRepository

) : ViewModel() {

    private val _state = MutableStateFlow(HomeViewState())
    private val refreshing = MutableStateFlow(false)

    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
        }
    }
}

data class HomeViewState(

    val refreshing: Boolean = false,
    val errorMessage: String? = null

)