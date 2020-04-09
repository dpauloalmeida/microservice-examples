package com.example.rentalcar.insurance

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.MessageChannel

interface InsuranceProcess {
    companion object {
        const val CREATED_IN = "createdIn"
    }

    @Input(CREATED_IN)
    fun created(): MessageChannel

}
