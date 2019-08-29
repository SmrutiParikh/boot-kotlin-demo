package com.smruti.kotlin.bootkotlindemo.flux

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.web.reactive.function.server.*

@Configuration
class Router(private val handler: Handler){

    @Bean
    fun route() = router{
        accept(TEXT_PLAIN).nest {
            (GET("/hello")).invoke { handler.hello()}
        }
    }
}