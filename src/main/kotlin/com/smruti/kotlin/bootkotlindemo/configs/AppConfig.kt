package com.smruti.kotlin.bootkotlindemo.configs

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
class AppConfig {
    val propertyPlaceholderConfigurer: PropertyPlaceholderConfigurer
        @Bean
        get() {
            val ppc = PropertyPlaceholderConfigurer()
            ppc.setLocation(ClassPathResource("application.properties"))
            ppc.setIgnoreUnresolvablePlaceholders(true)
            return ppc
        }
}