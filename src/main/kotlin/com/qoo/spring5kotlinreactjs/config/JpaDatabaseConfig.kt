package com.qoo.spring5kotlinreactjs.config

import com.qoo.spring5kotlinreactjs.config.properties.DataSourceHikariProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Executors


@Configuration
@EnableConfigurationProperties(DataSourceHikariProperties::class)
@EnableJpaRepositories(basePackages = ["com.qoo.spring5kotlinreactjs"])
class JpaDatabaseConfig {

    @Autowired
    lateinit var dataSourceHikariProperties: DataSourceHikariProperties

    @Bean
    fun jdbcScheduler(): Scheduler {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(dataSourceHikariProperties.maximumPoolSize))
    }
}