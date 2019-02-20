package com.hammerhead.io.service.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(value = ["com.hammerhead.io.service"])
@ComponentScan(value = ["com.hammerhead.io.service"])
class DbConfig {

    @Bean
    @ConfigurationProperties(prefix = "hammerhead.db")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }
}