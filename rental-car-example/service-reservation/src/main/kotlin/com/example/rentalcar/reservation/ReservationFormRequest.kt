package com.example.rentalcar.reservation

import java.time.LocalDate

data class ReservationFormRequest(
    val customerId: String,
    val inventoryId: String,
    val startDate: LocalDate,
    val endDate: LocalDate
)
