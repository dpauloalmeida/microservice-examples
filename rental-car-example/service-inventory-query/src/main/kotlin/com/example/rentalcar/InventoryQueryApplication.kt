package com.example.rentalcar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class InventoryQueryApplication

fun main(args: Array<String>) {
	runApplication<InventoryQueryApplication>(*args)
}
