package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation
import com.example.rentalcar.domain.ReservationStatus
import java.util.*

fun ReservationFormRequest.toReservation() = Reservation(
    id = UUID.randomUUID().toString(),
    customerId = customerId,
    inventoryId = inventoryId,
    startDate = startDate,
    endDate = endDate,
    status = ReservationStatus.CREATED
)

fun Reservation.toReservationResponse() = ReservationResponse(
    id = id,
    customerId = customerId,
    inventoryId = inventoryId,
    status = status
)