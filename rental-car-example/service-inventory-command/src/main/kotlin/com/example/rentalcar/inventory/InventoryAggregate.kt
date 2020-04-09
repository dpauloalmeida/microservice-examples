package com.example.rentalcar.inventory

import com.fasterxml.jackson.databind.ObjectMapper
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.*
import org.axonframework.spring.stereotype.Aggregate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.support.MessageBuilder

@Aggregate
class InventoryAggregate() {

    @Autowired
    private lateinit var inventoryProcessor: InventoryProcessor

    @AggregateIdentifier
    private lateinit var inventoryId: String
    private lateinit var vehicleId: String
    private var reserved: Boolean? = null

    @CommandHandler
    constructor(command: AddInventoryCommand): this() {
        apply(InventoryAddedEvent(command.inventoryId, command.vehicleId))
    }

    @EventSourcingHandler
    fun on(event: InventoryAddedEvent) {
        inventoryId = event.inventoryId
        vehicleId = event.vehicleId
        reserved = false
    }

    @CommandHandler
    fun handle(command: ReserveInventoryCommand) {
        if (reserved!!) {
            throw IllegalStateException("Cannot reserve a vehicle which has been reserved yet.");
        }
        apply(InventoryReservedEvent(command.inventoryId))
    }

    @EventSourcingHandler
    fun on(event: InventoryReservedEvent) {
        reserved = true
    }
}
