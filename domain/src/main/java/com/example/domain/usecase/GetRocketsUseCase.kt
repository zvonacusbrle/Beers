package com.example.domain.usecase


import com.apollographql.apollo3.ApolloCall
import com.example.domain.Entity.Rocket

interface GetRockets {
    suspend fun execute(param: Any): ApolloCall<Rocket>
}

 interface GetRocketsUseCase: GetRockets {
    override suspend fun execute(param: Any): ApolloCall<Rocket>
}
