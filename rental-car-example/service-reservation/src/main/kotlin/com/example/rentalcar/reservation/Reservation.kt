package com.example.rentalcar.reservation

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Reservation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val customerId: Long,

    val vehicleId: Long,

    val startDate: LocalDate,

    val endDate: LocalDate,

    @Enumerated(EnumType.STRING)
    val status: ReservationStatus

)
