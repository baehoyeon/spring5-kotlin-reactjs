package com.qoo.spring5kotlinreactjs.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.qoo.spring5kotlinreactjs"])
class JpaDatabaseConfig