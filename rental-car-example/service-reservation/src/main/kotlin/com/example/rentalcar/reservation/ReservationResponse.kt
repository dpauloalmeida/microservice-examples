package com.example.rentalcar.reservation

data class ReservationResponse(
    val id: Long,
    val customerId: Long,
    val vehicleId: Long,
    val status: ReservationStatus
)
