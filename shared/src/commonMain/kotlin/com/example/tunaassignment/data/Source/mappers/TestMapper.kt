package com.example.tunaassignment.data.Source.mappers

import com.example.tunaassignment.data.Source.DTO.TestDto
import com.example.tunaassignment.domain.model.Test

fun List<TestDto>.toTestList(): List<Test> {
    return this.map { dto ->
        Test(userId = dto.userId,
            body = dto.body,
            id = dto.id,
            title = dto.title)
    }
}