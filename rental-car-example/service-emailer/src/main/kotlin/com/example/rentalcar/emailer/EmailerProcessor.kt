package com.example.rentalcar.emailer

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface EmailerProcessor {
    companion object {
        const val CREATED_IN = "createdIn"
        const val CAR_RESERVED_AT_LOCATION_IN = "carReservedAtLocationIn"
    }

    @Input(CREATED_IN)
    fun created(): MessageChannel

    @Input(CAR_RESERVED_AT_LOCATION_IN)
    fun carReservedAtLocation(): MessageChannel

}
