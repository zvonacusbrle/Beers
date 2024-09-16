package com.example.rockets

import com.example.domain.Entity.RocketsList
import com.example.domain.usecase.GetRocketsUseCase

class RocketListConverter : CommonResultConverter<GetRocketsUseCase.Response, RocketsList>() {

    override fun convertSuccess(data: GetRocketsUseCase.Response): RocketsList {
        return RocketsList(
            items = data.rockets.items

        )
    }
}