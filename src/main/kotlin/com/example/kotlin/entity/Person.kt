package com.example.kotlin.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id

@Data
@NoArgsConstructor
@AllArgsConstructor
data class Person (
        @Id
        val id: Long? = null,
        val firstName: String? = null,
        val secondName: String? = null,
        val yearsOld: Int? = null
)