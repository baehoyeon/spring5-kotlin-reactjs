package com.qoo.spring5kotlinreactjs.config

import com.qoo.spring5kotlinreactjs.interfaces.hello.HelloHandler
import com.qoo.spring5kotlinreactjs.interfaces.user.UserApiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.resources
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class AppRoutes {

    @Bean
    fun apiRouter(userApiHandler: UserApiHandler) = router {
        (accept(MediaType.APPLICATION_JSON_UTF8) and "/api").nest {
            GET("/users", userApiHandler::handleGetUserList)
            GET("/users/{id}", userApiHandler::handleGetById)
        }
    }

    @Bean
    fun appRouter(helloHandler: HelloHandler) = router {
        GET("/", helloHandler::hello)
    }

    @Bean
    @DependsOn("appRouter")
    fun resourceRouter(): RouterFunction<ServerResponse> = resources("/**", ClassPathResource("static/"))
}