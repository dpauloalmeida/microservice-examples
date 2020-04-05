package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository : JpaRepository<Reservation, Long> {

}
