package com.example.rentalcar.insurance

import com.example.rentalcar.domain.Reservation
import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Component

@Component
class InsurancePartnerClient {

    companion object {
        private val LOG = LoggerFactory.getLogger(InsurancePartnerClient::class.java)
    }

    @Retryable(maxAttempts = 5, backoff = Backoff(delay = 2000, multiplier = 2.0))
    fun applyInsurance(event: Reservation) {
        LOG.info("Request solicitation to Insurance Partner third company")
    }
}
