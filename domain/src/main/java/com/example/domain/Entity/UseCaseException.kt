package com.example.domain.Entity

sealed class UseCaseException(cause: Throwable) : Throwable(cause) {

    class RocketException(cause: Throwable) : UseCaseException(cause)

    class UnknownException(cause: Throwable) : UseCaseException(cause)


    companion object {

        fun createFromThrowable(throwable: Throwable): UseCaseException {
            return if (throwable is UseCaseException) throwable else UnknownException(throwable)
        }
    }
}