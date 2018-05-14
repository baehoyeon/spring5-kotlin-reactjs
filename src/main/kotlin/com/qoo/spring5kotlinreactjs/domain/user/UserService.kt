package com.qoo.spring5kotlinreactjs.domain.user

import com.qoo.spring5kotlinreactjs.infra.JdbcAsyncUtils
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(val jdbcAsyncUtils: JdbcAsyncUtils, val userRepository: UserRepository) {
    fun list(): Flux<User> = jdbcAsyncUtils.asyncFlux({ Flux.fromIterable(userRepository.findAll()) })
    fun getById(id: Long): Mono<User> = jdbcAsyncUtils.asyncMono({Mono.justOrEmpty(userRepository.findById(id))})
//    fun getById(id: Long): Mono<User> = jdbcAsyncUtils.asyncMono(Callable<User> { userRepository.findById(id).orElse(null) })
}