package com.example.classwork_8.common.utils

sealed class Resource<T> {
    class Success<T>(val result: T) : Resource<T>()
    class Error<T>(val errorMessage: String) : Resource<T>()
    class Loader<T>(val isLoading: Boolean) : Resource<T>()
}
