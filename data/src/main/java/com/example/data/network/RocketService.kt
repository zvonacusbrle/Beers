package com.example.data.network

import com.example.domain.Entity.Rocket
import kotlinx.coroutines.flow.Flow

interface RocketService {
    suspend fun fetchRockets(): Flow<List<Rocket>?>
}