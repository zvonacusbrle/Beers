package com.example.domain.repository

import com.example.domain.Entity.Rocket
import kotlinx.coroutines.flow.Flow


interface RocketsRepository{
    suspend fun getRockets() : Flow<List<Rocket>?>
}