package com.example.domain.repository

import com.example.domain.Entity.Rocket
import com.example.domain.Entity.RocketsList
import kotlinx.coroutines.flow.Flow


interface RocketsRepository{
    suspend fun getRockets() : Flow<RocketsList>
}