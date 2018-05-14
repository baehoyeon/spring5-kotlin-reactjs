package com.qoo.spring5kotlinreactjs.interfaces.user

import com.qoo.spring5kotlinreactjs.domain.user.User
import com.qoo.spring5kotlinreactjs.domain.user.UserService
import com.qoo.spring5kotlinreactjs.infra.json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class UserApiHandler(val userService: UserService) {

    fun handleGetUserList(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userService.list(), User::class.java)

    fun handleGetById(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userService.getById(request.pathVariable("id").toLong()), User::class.java)
}