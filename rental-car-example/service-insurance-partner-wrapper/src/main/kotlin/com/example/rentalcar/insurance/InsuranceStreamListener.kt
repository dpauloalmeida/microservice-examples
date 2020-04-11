package com.example.rentalcar.insurance

import com.example.rentalcar.domain.Reservation
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service

@Service
class InsuranceStreamListener(
    private val insurancePartnerClient: InsurancePartnerClient
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(InsuranceStreamListener::class.java)
    }

    @StreamListener(InsuranceProcess.CREATED_IN)
    fun listen(event: Reservation) {
        LOG.info("Processing event: $event - ${InsuranceProcess.CREATED_IN}")

        insurancePartnerClient.applyInsurance(event)
    }
}