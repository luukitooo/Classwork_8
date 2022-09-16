package com.example.classwork_8.common.utils

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

interface RequestHandler {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>) = flow<Resource<T>> {
        emit(Resource.Loader(isLoading = true))
        try {
            val response = call()
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()!!))
            } else {
                emit(Resource.Error(response.errorBody()!!.string()))
            }
        } catch (t: Throwable) {
            emit(Resource.Error(t.message!!))
        }
        emit(Resource.Loader(isLoading = false))
    }

}