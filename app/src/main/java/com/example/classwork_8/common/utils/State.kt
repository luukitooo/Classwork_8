package com.example.classwork_8.common.utils

data class State<T>(
    val value: T? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean? = null
)
