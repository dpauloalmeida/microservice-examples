package com.example.rentalcar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class ZuulApplication

fun main(args: Array<String>) {
	runApplication<ZuulApplication>(*args)
}
