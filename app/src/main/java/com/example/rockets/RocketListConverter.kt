package com.example.rockets

import android.content.Context
import com.example.domain.Entity.Rocket
import com.example.domain.usecase.GetRocketsUseCase

class RocketListConverter(private val context: Context) :
    CommonResultConverter<GetRocketsUseCase.Response, Rocket>() {

    override fun convertSuccess(data: GetRocketsUseCase.Response): Rocket {
        return (

        )
    }


}