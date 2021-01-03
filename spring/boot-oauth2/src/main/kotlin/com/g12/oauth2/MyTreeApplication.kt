package com.g12.oauth2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyTreeApplication

fun main(args: Array<String>) {
    runApplication<MyTreeApplication>(*args)
}