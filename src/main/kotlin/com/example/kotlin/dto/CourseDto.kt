package com.example.kotlin.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
data class CourseDto(
        val id: Long,
        val courseName: String,
        val dateRange: String,
        var person: PersonDto?
)