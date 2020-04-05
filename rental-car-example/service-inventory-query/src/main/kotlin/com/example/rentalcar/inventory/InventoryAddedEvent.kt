package com.example.rentalcar.inventory

data class InventoryAddedEvent(
    val inventoryId: String,
    val vehicleId: String
)
