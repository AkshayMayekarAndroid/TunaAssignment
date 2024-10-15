package com.example.tunaassignment.domain

sealed class ResponseState<T>(val data :T?=null, val message:String?=null, val timeStamp: Long? = null){
    class Loading<T>(): ResponseState<T>()
    class Success<T>(data:T?=null): ResponseState<T>(data)
    class Error<T>(message:String?=null, timeStamp: Long? = null): ResponseState<T>(message = message, timeStamp = timeStamp)
}

fun <T, R> ResponseState<T>.mapSuccess(mapper: (T) -> R): ResponseState<R> {
    return when (this) {
        is ResponseState.Success -> ResponseState.Success(data?.let { mapper(it) })
        is ResponseState.Error ->  ResponseState.Error(message, null) // Pass through errors
        is ResponseState.Loading -> ResponseState.Loading()
    }
}