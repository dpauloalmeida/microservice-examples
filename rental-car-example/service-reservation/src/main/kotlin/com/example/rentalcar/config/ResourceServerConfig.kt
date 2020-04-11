package com.example.rentalcar.config

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler




@Configuration
class ResourceServerConfig(
    private val expressionHandler: OAuth2WebSecurityExpressionHandler
) : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/reservations").hasAnyRole("USER")
            .antMatchers(HttpMethod.GET, "/reservations/{id}").access("@reservationAuthorizationService.isReservationCustomer(#id, authentication)")
    }

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.expressionHandler(expressionHandler)
    }
}