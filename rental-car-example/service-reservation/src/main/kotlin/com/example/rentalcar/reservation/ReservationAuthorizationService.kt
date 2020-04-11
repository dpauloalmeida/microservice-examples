package com.example.rentalcar.reservation

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class ReservationAuthorizationService(
    private val reservationRepository: ReservationRepository,
    private val customerClient: CustomerClient
) {

    @HystrixCommand(fallbackMethod = "isReservationCustomerFallback")
    fun isReservationCustomer(reservationId: String, authentication: Authentication): Boolean {
        val username = authentication.principal as String

        val customerId = customerClient.getCustomerDetail(username, authentication)

         return customerId.role == "ROLE_USER" && reservationRepository.existsByIdAndCustomerId(reservationId, customerId.id)
    }

    fun isReservationCustomerFallback(reservationId: String, authentication: Authentication) = false

}
