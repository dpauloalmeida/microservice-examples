package com.example.rentalcar.reservation

import java.time.LocalDate

data class ReservationFormRequest(
    val customerId: Long,
    val vehicleId: Long,
    val startDate: LocalDate,
    val endDate: LocalDate
)
