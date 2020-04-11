package com.example.rentalcar.config

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler

@Configuration
class SecurityConfig {

    @Bean
    fun oAuth2WebSecurityExpressionHandler(applicationContext: ApplicationContext): OAuth2WebSecurityExpressionHandler {
        val expressionHandler = OAuth2WebSecurityExpressionHandler()
        expressionHandler.setApplicationContext(applicationContext)
        return expressionHandler
    }
}