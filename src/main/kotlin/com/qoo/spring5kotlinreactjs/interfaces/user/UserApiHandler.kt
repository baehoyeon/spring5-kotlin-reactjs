package com.qoo.spring5kotlinreactjs.interfaces.user

import com.qoo.spring5kotlinreactjs.domain.user.User
import com.qoo.spring5kotlinreactjs.domain.user.UserRepository
import com.qoo.spring5kotlinreactjs.infra.json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class UserApiHandler(val userRepository: UserRepository) {

    fun handleGetUserList(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userRepository.list(), User::class.java)

    fun handleGetById(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userRepository.getBy(java.lang.Long.parseLong(request.pathVariable("id"))), User::class.java)
                    .switchIfEmpty(ServerResponse.notFound().build())
}
