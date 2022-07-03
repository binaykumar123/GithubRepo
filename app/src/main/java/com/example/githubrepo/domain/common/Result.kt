package com.example.githubrepo.domain.common

sealed class Result<T> {
    data class Success<T>(var data: T) : Result<T>()
    data class ApiError<T>(var error: String) : Result<T>()
    data class Loading<T>(var isLoading: Boolean) : Result<T>()

    companion object {
        fun <T> success(data: T): Result<T> = Success(data)
        fun <T> apiError(e: String): Result<T> = ApiError(e)
        fun <T> loading(isLoading: Boolean): Result<T> = Loading(isLoading)
    }
}