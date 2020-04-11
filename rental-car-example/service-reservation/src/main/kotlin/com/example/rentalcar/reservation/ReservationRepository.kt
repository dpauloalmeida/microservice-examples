package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ReservationRepository : JpaRepository<Reservation, String> {
    fun existsByIdAndCustomerId(reservationId: String, customerId: String): Boolean
}
