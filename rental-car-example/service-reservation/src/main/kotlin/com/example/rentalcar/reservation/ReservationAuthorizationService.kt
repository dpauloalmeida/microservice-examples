package com.example.rentalcar.reservation

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service

@Service
class ReservationAuthorizationService(
    private val reservationRepository: ReservationRepository
) {

    fun isReservationCustomer(reservationId: String, authentication: Authentication): Boolean {
        val username = authentication.principal as String
        val roles = authentication.authorities

        val customerId = findCustomerByUsername(username)

         return hasRole(roles) && reservationRepository.existsByIdAndCustomerId(reservationId, customerId)
    }

    private fun findCustomerByUsername(username: String): String {
        return if(username == "danilo") "1" else "0"
    }

    private fun hasRole(roles: Collection<GrantedAuthority>): Boolean {
        return roles.any { it.authority == "ROLE_USER" }
    }
}