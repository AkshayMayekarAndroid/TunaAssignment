package com.example.tunaassignment.domain.repository

import com.example.tunaassignment.domain.ResponseState
import com.example.tunaassignment.domain.model.Test
import kotlinx.coroutines.flow.Flow

interface TestRepository {
    suspend fun fetchData() : Flow<ResponseState<List<Test>>>
}