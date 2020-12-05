package com.example.kotlin.repository

import com.example.kotlin.entity.Course
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CourseRepository: ReactiveCrudRepository<Course, Long> {}