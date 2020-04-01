package com.example.rentalcar.reservation

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ReservationProducer(
    private val kafkaTemplate: KafkaTemplate<String, Reservation>
) {

    @Value("\${kafka.producer.topic}")
    lateinit var reservationCreated: String

    fun send(reservation: Reservation) = kafkaTemplate.send(reservationCreated, reservation).get().run {
        println("sent ${recordMetadata.topic()}:::partition ${recordMetadata.partition()} " +
                "/ offset ${recordMetadata.offset()} / timestamp ${recordMetadata.timestamp()}")
    }

}