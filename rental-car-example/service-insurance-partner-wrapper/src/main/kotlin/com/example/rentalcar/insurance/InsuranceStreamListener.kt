package com.example.rentalcar.insurance

import com.example.rentalcar.domain.Reservation
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service

@Service
class InsuranceStreamListener(
    private val insurancePartnerClient: InsurancePartnerClient
) {

    @StreamListener(InsuranceProcess.CREATED_IN)
    fun listen(event: Reservation) {
        insurancePartnerClient.applyInsurance(event)
    }
}