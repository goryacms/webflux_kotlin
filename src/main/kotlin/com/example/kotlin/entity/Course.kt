package com.example.kotlin.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("courses")
data class Course(
        @Id
        val id: Long,
        val courseName: String,
        val dateRange: String,
        val personId: Long
)