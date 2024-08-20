package com.example.domain

import com.example.domain.Entity.Rocket
import com.example.domain.Entity.RocketsList
import com.example.domain.Entity.UseCase
import com.example.domain.usecase.GetRocketsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Test
import org.junit.Assert;
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith



class FakeGetRocketsUseCase {

    private val configuration = UseCase.Configuration(StandardTestDispatcher())

    @Test
    fun `get rockets success`() = runBlocking {
        val rockets = listOf(Rocket("1", "FalconX", "Basic rocket"))
        val fakeRocketsRepository = FakeRocketsRepository().apply {
            rocketsList.add(RocketsList(rockets))
        }
        val useCase = GetRocketsUseCase(configuration = configuration, rocketsRepository = fakeRocketsRepository)
        val result = useCase.execute(GetRocketsUseCase.Request).toList()

        assertEquals(1, result.size)
        assert(true)
    }
}

