package com.qoo.spring5kotlinreactjs

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class BootApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(BootApplication::class.java)
            .web(WebApplicationType.REACTIVE)
            .run(*args)
}