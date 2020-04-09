package com.example.rentalcar

import com.example.rentalcar.emailer.EmailerProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
@EnableBinding(EmailerProcessor::class)
class EmailerApplication

fun main(args: Array<String>) {
	runApplication<EmailerApplication>(*args)
}
