package com.smruti.kotlin.bootkotlindemo.flux

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
class Handler{
    fun hello(): Mono<ServerResponse> {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromObject("Hello, Spring!"))
    }
}