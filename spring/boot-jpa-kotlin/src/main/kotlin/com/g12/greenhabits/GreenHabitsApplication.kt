package com.g12.greenhabits

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreenHabitsApplication

fun main(args: Array<String>) {
    runApplication<GreenHabitsApplication>(*args)
}