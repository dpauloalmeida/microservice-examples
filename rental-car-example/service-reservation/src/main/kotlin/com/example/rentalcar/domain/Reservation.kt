package com.example.rentalcar.core.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Reservation(

    @Id
    val id: String,

    val customerId: String,

    val inventoryId: String,

    val startDate: LocalDate,

    val endDate: LocalDate,

    @Enumerated(EnumType.STRING)
    val status: ReservationStatus

)
