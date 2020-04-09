package com.example.rentalcar.reservation

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.stereotype.Component

@Component
interface ReservationProcessor {
    companion object {
        const val CREATED_OUT = "createdOut"
    }

    @Output(CREATED_OUT)
    fun created(): MessageChannel
}
