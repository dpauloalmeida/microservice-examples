package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Inventory

fun Inventory.toInventoryResponse() = InventoryResponse(
    inventoryId = id,
    vehicleId = vehicleId
)