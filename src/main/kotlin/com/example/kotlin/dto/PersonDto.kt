package com.example.kotlin.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
data class PersonDto(
        val id: Long?,
        val firstName: String?,
        val secondName: String?,
        val yearsOld: Int?
)