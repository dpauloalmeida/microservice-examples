package com.example.rentalcar.inventory

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class InventoryCommandServiceImpl(
    private val commandGateway: CommandGateway,
    private val inventoryProcessor: InventoryProcessor
) : InventoryCommandService {

    override fun create(form: InventoryFormRequest) {
        val command = AddInventoryCommand(form.inventoryId, form.vehicleId)
        commandGateway.send<CompletableFuture<String>>(command)
    }

    override fun rent(inventoryId: String) {
        val command = ReserveInventoryCommand(inventoryId)
        commandGateway.sendAndWait<String>(command)
        inventoryProcessor.carReservedAtLocation().send(MessageBuilder.withPayload(inventoryId).build())
    }
}