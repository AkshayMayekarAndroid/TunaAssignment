package com.example.tunaassignment.di

import com.example.tunaassignment.data.source.Api.ApiClient
import com.example.tunaassignment.data.repository.TestRepositoryImpl
import com.example.tunaassignment.domain.repository.TestRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*

import org.koin.dsl.module

val sharedModule =  module {

    single {
        HttpClient {
            install(ContentNegotiation) {
                json() // Use the Kotlinx serialization for JSON
            }
        }
    }
    single { ApiClient(get()) } // Provide ApiClient with Ktor client
    single { TestRepositoryImpl(get()) as TestRepository }

}