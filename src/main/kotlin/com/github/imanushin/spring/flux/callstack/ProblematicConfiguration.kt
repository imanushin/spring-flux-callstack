package com.github.imanushin.spring.flux.callstack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@SpringBootApplication
@EnableWebFlux
open class ProblematicConfiguration {

    @Bean
    open fun httpEndpoints() = coRouter {
        (1..1000).forEach { index ->
            GET("/g/$index") {
                try {
                    error(":'(")
                } catch (e: Throwable) {
                    ServerResponse
                            .status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .bodyValueAndAwait(e.stackTrace.joinToString(System.lineSeparator()))
                }
            }
        }
    }
}

fun main() {
    runApplication<ProblematicConfiguration>()
}