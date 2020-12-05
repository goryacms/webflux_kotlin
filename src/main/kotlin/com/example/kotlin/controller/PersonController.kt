package com.example.kotlin.controller

import com.example.kotlin.KotlinApplication
import com.example.kotlin.dto.PersonDto
import com.example.kotlin.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping(
        path = [KotlinApplication.URL_PATH + "/person"]
)
class PersonController(
        val personService: PersonService
) {
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<ResponseEntity<PersonDto>> {
        return personService.getById(id)
                .map { ResponseEntity.ok(it) }
    }

    @PostMapping()
    fun create(@RequestBody person: PersonDto): Mono<ResponseEntity<PersonDto>> {
        return personService.save(person)
                .map { savedPerson -> ResponseEntity(savedPerson, HttpStatus.CREATED) }
    }
}