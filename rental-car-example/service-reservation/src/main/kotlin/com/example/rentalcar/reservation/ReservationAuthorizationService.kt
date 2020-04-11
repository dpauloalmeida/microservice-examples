package com.example.rentalcar.reservation

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class ReservationAuthorizationService(
    private val reservationRepository: ReservationRepository,
    private val customerClient: CustomerClient
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(ReservationAuthorizationService::class.java)
    }

    @HystrixCommand(fallbackMethod = "isReservationCustomerFallback")
    fun isReservationCustomer(reservationId: String, authentication: Authentication): Boolean {
        LOG.info("Validation access reservationId: {} authentication: {}", reservationId, authentication)

        val username = authentication.principal as String

        val customerId = customerClient.getCustomerDetail(username, authentication)

         return customerId.role == "ROLE_USER" && reservationRepository.existsByIdAndCustomerId(reservationId, customerId.id)
    }

    fun isReservationCustomerFallback(reservationId: String, authentication: Authentication) = false

}
