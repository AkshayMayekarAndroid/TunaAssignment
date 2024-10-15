package com.example.tunaassignment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform