package com.example.domain

import com.example.domain.Entity.Rocket
import com.example.domain.Entity.RocketsList
import com.example.domain.repository.RocketsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class FakeRocketsRepository : RocketsRepository {

    val rocketsList = mutableListOf<RocketsList>()
    override suspend fun getRockets(): Flow<RocketsList> {
        return rocketsList.asFlow()
    }
}