package com.example.domain.Entity

data class Rocket(
    val id: String?,
    val name: String?,
    val description: String?,
)

data class RocketsList(
    val items: List<Rocket> = listOf()
)