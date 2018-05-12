package com.qoo.spring5kotlinreactjs.domain.user

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class UserRepository {

    private val userDatabase = arrayOf(
            User(id = 1L, name = "qoo", phoneNumber = "010-1234-1234"),
            User(id = 2L, name = "pooh", phoneNumber = "010-1234-4321"),
            User(id = 3L, name = "kotlin", phoneNumber = "010-4321-1234"),
            User(id = 4L, name = "java", phoneNumber = "010-4321-4321")
    )

    fun getBy(id: Long? = 0L): Mono<User> {
        return Mono.justOrEmpty(userDatabase
                .filter { it.id == id }
                .getOrNull(0))
    }

    fun list(): Flux<User> {
        return Flux.fromArray(userDatabase)
    }
}
