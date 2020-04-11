package com.example.rentalcar.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer

@Configuration
class AuthorizationServerConfig(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder
) : AuthorizationServerConfigurerAdapter() {

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
            .withClient("rentalcar-client")
            .secret(passwordEncoder.encode("12345"))
            .authorizedGrantTypes("password")
            .scopes("web")
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authenticationManager(authenticationManager)
            .userDetailsService(userDetailsService)
    }
}