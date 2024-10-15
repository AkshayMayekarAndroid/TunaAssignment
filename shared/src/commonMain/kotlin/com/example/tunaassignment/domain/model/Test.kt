package com.example.tunaassignment.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Test(
    var userId: Int? = null,
    var id: Int? = null,
    var title: String? = null,
    var body: String? = null
) {}
