package com.example.tunaassignment.data.Source.Api

import com.example.tunaassignment.data.Source.DTO.TestDto
import com.example.tunaassignment.domain.ResponseState
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class ApiClient(private val client: HttpClient) {
    suspend fun getTestData(): ResponseState<List<TestDto>> {
        try {
            val response: HttpResponse = client.get("https://jsonplaceholder.typicode.com/posts") // Replace with your API endpoint
            val responseBody = response.bodyAsText() // Get the response body as text
            val data: List<TestDto> = Json.decodeFromString(responseBody) // Deserialize to List<Test>
            return ResponseState.Success(data) // Emit success state with data
        } catch (e: Exception) {
            return ResponseState.Error(e.message) // Emit error state with exception
        }
    }
}