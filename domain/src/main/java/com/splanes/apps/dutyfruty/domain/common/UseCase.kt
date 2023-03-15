package com.splanes.apps.dutyfruty.domain.common

abstract class UseCase<P, R> {

    suspend operator fun invoke(params: P): Result<R> =
        try {
            val result = execute(params)
            Success(result)
        } catch (err: KnownError) {
            Failure(err)
        } catch (err: Throwable) {
            Failure(KnownError.Undefined)
        }

    abstract suspend fun execute(params: P): R

    sealed class Result<out T>

    data class Success<out T>(val result: T) : Result<T>()
    data class Failure(val error: KnownError) : Result<Nothing>()
}
