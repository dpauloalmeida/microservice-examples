package com.example.rentalcar.domain

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Inventory(
    @Id
    val id: String,
    val vehicleId: String,
    var reserved: Boolean = false
)
