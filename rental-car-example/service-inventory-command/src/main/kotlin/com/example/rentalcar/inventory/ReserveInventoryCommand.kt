package com.example.rentalcar.inventory

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class ReserveInventoryCommand(
    @TargetAggregateIdentifier
    val inventoryId: String
)
