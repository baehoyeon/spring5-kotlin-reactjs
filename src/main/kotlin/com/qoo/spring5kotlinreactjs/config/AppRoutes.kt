package com.qoo.spring5kotlinreactjs.config

import com.qoo.spring5kotlinreactjs.interfaces.IndexHandler
import com.qoo.spring5kotlinreactjs.interfaces.hello.HelloHandler
import com.qoo.spring5kotlinreactjs.interfaces.user.UserApiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.MediaType.TEXT_HTML
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
    fun appRouter(indexHandler: IndexHandler, helloHandler: HelloHandler) = router {
        resources("/**", ClassPathResource("static/"))
        accept(TEXT_HTML).nest {
            GET("/hello", helloHandler::hello)
            GET("/", indexHandler::reactApp)
            GET("/contact", indexHandler::reactApp)
        }
    }
}