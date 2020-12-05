package com.example.kotlin.controller

import com.example.kotlin.KotlinApplication
import com.example.kotlin.dto.CourseDto
import com.example.kotlin.dto.PersonDto
import com.example.kotlin.service.CourseService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping(
        path = [KotlinApplication.URL_PATH + "/course"]
)
class CourseController(
        val courseService: CourseService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<ResponseEntity<CourseDto>> {
        return courseService.getById(id)
                .map { ResponseEntity.ok(it) }
    }
}