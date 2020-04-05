package com.example.rentalcar.reservation

import com.example.rentalcar.domain.ReservationStatus

data class ReservationResponse(
    val id: String,
    val customerId: String,
    val inventoryId: String,
    val status: ReservationStatus
)
