package com.qoo.spring5kotlinreactjs.infra

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import java.util.concurrent.Callable

@Service
class JdbcAsyncUtils(val scheduler: Scheduler) {
    fun <T> asyncFlux(function: () -> Flux<T>): Flux<T> = Flux.defer(function).subscribeOn(scheduler)
    fun <T> asyncMono(function: () -> Mono<T>): Mono<T> = Mono.defer(function).subscribeOn(scheduler)
    fun <T> asyncMono(callable: Callable<T>): Mono<T> = Mono.fromCallable(callable).publishOn(scheduler)
}
