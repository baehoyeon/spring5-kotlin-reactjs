package com.qoo.spring5kotlinreactjs.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.datasource.hikari")
class DataSourceHikariProperties(var maximumPoolSize: Int)
