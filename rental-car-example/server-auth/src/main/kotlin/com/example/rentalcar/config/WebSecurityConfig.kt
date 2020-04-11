package com.example.rentalcar.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .passwordEncoder(passwordEncoder())
            .withUser("danilo")
            .password(passwordEncoder().encode("12345"))
            .roles("USER")
    }

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return super.userDetailsService()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}