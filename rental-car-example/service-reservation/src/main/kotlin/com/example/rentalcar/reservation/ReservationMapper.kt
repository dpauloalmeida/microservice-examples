package com.example.rentalcar.reservation

fun ReservationFormRequest.toReservation() = Reservation(
    customerId = customerId,
    vehicleId = vehicleId,
    startDate = startDate,
    endDate = endDate,
    status = ReservationStatus.PENDING
)

fun Reservation.toReservationResponse() = ReservationResponse(
    id = id,
    customerId = customerId,
    vehicleId = vehicleId,
    status = status
)