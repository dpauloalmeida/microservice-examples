package com.example.rentalcar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
class AuthApplication

fun main(args: Array<String>) {
	runApplication<AuthApplication>(*args)
}
