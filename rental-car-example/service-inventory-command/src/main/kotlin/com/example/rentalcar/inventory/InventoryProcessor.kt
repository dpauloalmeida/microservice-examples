package com.example.rentalcar.inventory

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface InventoryProcessor {
    companion object {
        const val CREATED_IN = "createdIn"
        const val CAR_RESERVED_AT_LOCATION_OUT = "carReservedAtLocationOut"
    }

    @Input(CREATED_IN)
    fun created(): MessageChannel

    @Output(CAR_RESERVED_AT_LOCATION_OUT)
    fun carReservedAtLocation(): MessageChannel

}