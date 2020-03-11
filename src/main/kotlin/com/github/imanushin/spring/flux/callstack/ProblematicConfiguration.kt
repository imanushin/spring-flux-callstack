package com.github.imanushin.spring.flux.callstack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@SpringBootApplication
@EnableWebFlux
open class ProblematicConfiguration{

    @Bean
    open fun httpEndpoints() = coRouter {
        (1..100).forEach { index ->
            GET("/g/$index") {
                ServerResponse
                        .ok()
                        .bodyValueAndAwait(index)
            }
        }
    }
}

fun main() {
    runApplication<ProblematicConfiguration>()
}