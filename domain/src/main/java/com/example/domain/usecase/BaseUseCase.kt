package com.example.domain.usecase

abstract class BaseUseCase <in Params, out T>{
    abstract fun execute(params: Params) : T
}