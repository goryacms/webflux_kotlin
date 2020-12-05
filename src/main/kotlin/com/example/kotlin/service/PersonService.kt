package com.example.kotlin.service

import com.example.kotlin.dto.PersonDto
import com.example.kotlin.entity.Person
import com.example.kotlin.repository.PersonRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class PersonService(
        val personRepository: PersonRepository
) {
    fun getById(personId: Long): Mono<PersonDto> {
        return personRepository.findById(personId)
                .flatMap {
                    return@flatMap PersonDto(it.id, it.firstName, it.secondName, it.yearsOld)
                            .toMono()
                }
    }

    fun save(personRequest: PersonDto): Mono<PersonDto> {
        val person = Person()
        BeanUtils.copyProperties(personRequest, person)

        return personRepository.save(person)
                .map {
                    return@map PersonDto(it.id, it.firstName, it.secondName, it.yearsOld)
                }
    }

}