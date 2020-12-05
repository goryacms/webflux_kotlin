package com.example.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class KotlinApplication {
    companion object {
        const val URL_PATH: String = "/api/v1"
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinApplication>(*args)
}