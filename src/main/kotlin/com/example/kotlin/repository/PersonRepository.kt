package com.example.kotlin.repository

import com.example.kotlin.entity.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PersonRepository: ReactiveCrudRepository<Person, Long> {}