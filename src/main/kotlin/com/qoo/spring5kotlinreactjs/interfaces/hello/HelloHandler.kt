package com.qoo.spring5kotlinreactjs.interfaces.hello

import com.qoo.spring5kotlinreactjs.infra.html
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class HelloHandler {
    fun hello(request: ServerRequest): Mono<ServerResponse> = ok().html().render("hello")
}