package com.qoo.spring5kotlinreactjs.interfaces.user

import com.qoo.spring5kotlinreactjs.domain.user.User
import com.qoo.spring5kotlinreactjs.domain.user.UserForm
import com.qoo.spring5kotlinreactjs.domain.user.UserService
import com.qoo.spring5kotlinreactjs.infra.json
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Service
class UserApiHandler(val userService: UserService) {

    fun list(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userService.list(), User::class.java)

    fun getById(request: ServerRequest): Mono<ServerResponse> =
            ok().json()
                    .body(userService.getById(request.pathVariable("id").toLong()), User::class.java)

    fun addUser(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(UserForm::class.java)
                .flatMap {
                    userService.add(User(it.name, it.phone))
                            .flatMap { ok().build() }
                }
    }
}