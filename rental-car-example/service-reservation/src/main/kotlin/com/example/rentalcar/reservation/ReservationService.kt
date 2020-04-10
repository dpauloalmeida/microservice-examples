package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation

interface ReservationService {
    fun create(form: ReservationFormRequest): Reservation
    fun findById(id: String): ReservationResponse
}
