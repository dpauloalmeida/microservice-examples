package com.example.rentalcar.emailer

import com.example.rentalcar.domain.Reservation
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component


@Component
class EmailerStreamListener {

    companion object {
        private val LOG = LoggerFactory.getLogger(EmailerStreamListener::class.java)
    }

    @StreamListener(EmailerProcessor.CREATED_IN)
    fun listen(event: Reservation) {
        LOG.info("Processing event: $event - ${EmailerProcessor.CREATED_IN}")

        send("Processing reservation",
            mapOf("code" to event.id, "customer" to event.customerId, "inventory" to event.inventoryId))
    }

    @StreamListener(EmailerProcessor.CAR_RESERVED_AT_LOCATION_IN)
    fun listen(event: String) {
        LOG.info("Processing event: $event - ${EmailerProcessor.CAR_RESERVED_AT_LOCATION_IN}")

        send("Car reserved with success",
            mapOf("inventory" to event))
    }

    private fun send(header: String, content: Map<String, String>) {
        println("Sending email: $header")
        println("----------------------------------------")
        content.forEach { println("${it.key}: ${it.value}") }
        println("----------------------------------------")
        println()
    }
}