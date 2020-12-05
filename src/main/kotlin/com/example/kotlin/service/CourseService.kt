package com.example.kotlin.service

import com.example.kotlin.dto.CourseDto
import com.example.kotlin.dto.PersonDto
import com.example.kotlin.repository.CourseRepository
import com.example.kotlin.repository.PersonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CourseService(
        val courseRepository: CourseRepository,
        val personRepository: PersonRepository
) {
    fun getById(id: Long): Mono<CourseDto> {
        return courseRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .map {
                    return@map CourseDto(it.id, it.courseName, it.dateRange, null)
                }
                .flatMap {
                    return@flatMap personRepository.findById(it.id)
                            .switchIfEmpty(Mono.empty())
                            .map { person ->
                                PersonDto(person.id, person.firstName, person.secondName, person.yearsOld)
                            }
                            .map { person ->
                                it.person = person
                                return@map it
                            }
                }
    }

}