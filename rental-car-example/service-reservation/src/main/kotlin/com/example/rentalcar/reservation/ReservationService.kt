package com.example.rentalcar.reservation

interface ReservationService {
    fun create(form: ReservationFormRequest): ReservationResponse
    fun findById(id: Long): ReservationResponse
}
