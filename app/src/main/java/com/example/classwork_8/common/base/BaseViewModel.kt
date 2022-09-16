package com.example.classwork_8.common.base

import androidx.lifecycle.ViewModel
import com.example.classwork_8.common.utils.Resource
import com.example.classwork_8.common.utils.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class BaseViewModel: ViewModel() {

    protected fun <T> handleResponse(response: Flow<Resource<T>>, oldState: State<T>) = flow {
        var state = oldState
        response.collect {
            when (it) {
                is Resource.Success -> {
                    state = state.copy(value = it.result)
                    emit(state)
                }
                is Resource.Error -> {
                    state = state.copy(errorMessage = it.errorMessage)
                    emit(state)
                }
                is Resource.Loader -> {
                    state = state.copy(isLoading = it.isLoading)
                    emit(state)
                }
            }
        }
    }

}