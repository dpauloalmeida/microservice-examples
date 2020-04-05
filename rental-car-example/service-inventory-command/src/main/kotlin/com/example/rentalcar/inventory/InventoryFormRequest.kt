package com.example.rentalcar.inventory

import java.util.*

data class InventoryFormRequest(
    val inventoryId: String = UUID.randomUUID().toString(),
    val vehicleId: String
)
