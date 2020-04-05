package com.example.rentalcar.inventory

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class AddInventoryCommand(
    @TargetAggregateIdentifier
    val inventoryId: String,
    val vehicleId: String
)
