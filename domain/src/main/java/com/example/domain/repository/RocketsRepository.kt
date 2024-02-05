package com.example.domain.repository

import com.example.data.network.MyApi

class RocketsRepository(
    private val myApi: MyApi
) {
    suspend fun rocketsQuery() = myApi.fetchRockets()
}