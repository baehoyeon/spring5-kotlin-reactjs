package com.qoo.spring5kotlinreactjs.infra

import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.ServerResponse

fun ServerResponse.BodyBuilder.json() = contentType(APPLICATION_JSON_UTF8)

fun ServerResponse.BodyBuilder.html() = contentType(TEXT_HTML)