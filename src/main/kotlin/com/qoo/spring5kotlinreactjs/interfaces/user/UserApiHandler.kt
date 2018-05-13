package com.qoo.spring5kotlinreactjs.interfaces.user

import com.qoo.spring5kotlinreactjs.domain.user.User
import com.qoo.spring5kotlinreactjs.domain.user.UserRepository
import com.qoo.spring5kotlinreactjs.infra.json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserApiHandler(val userRepository: UserRepository) {

    fun handleGetUserList(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(Flux.fromIterable(userRepository.findAll()), User::class.java)

    fun handleGetById(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(Mono.justOrEmpty(userRepository.findById(request.pathVariable("id").toLong())), User::class.java)
}