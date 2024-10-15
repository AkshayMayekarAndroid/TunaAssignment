package com.example.tunaassignment.data.repository

import com.example.tunaassignment.data.source.Api.ApiClient
import com.example.tunaassignment.data.source.mappers.toTestList
import com.example.tunaassignment.domain.repository.TestRepository
import com.example.tunaassignment.domain.ResponseState
import com.example.tunaassignment.domain.mapSuccess
import com.example.tunaassignment.domain.model.Test
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestRepositoryImpl(val apiClient: ApiClient) : TestRepository {
    override suspend fun fetchData() : Flow<ResponseState<List<Test>>> {
        return flow {
            emit(ResponseState.Loading())
            val data = apiClient.getTestData().mapSuccess { it ->
                it.toTestList()
            }
            emit(data)
        }
    }
}