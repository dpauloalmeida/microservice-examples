package com.example.rentalcar

import com.example.rentalcar.insurance.InsuranceProcess
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
@EnableBinding(InsuranceProcess::class)
class InsurancePartnerWrapperApplication

fun main(args: Array<String>) {
	runApplication<InsurancePartnerWrapperApplication>(*args)
}
