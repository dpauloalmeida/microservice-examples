package com.example.rentalcar.inventory

import org.axonframework.commandhandling.gateway.CommandGateway
import org.slf4j.LoggerFactory
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class InventoryCommandServiceImpl(
    private val commandGateway: CommandGateway,
    private val inventoryProcessor: InventoryProcessor
) : InventoryCommandService {

    companion object {
        private val LOG = LoggerFactory.getLogger(InventoryCommandService::class.java)
    }

    override fun create(form: InventoryFormRequest) {
        LOG.info("Creating inventory: $form")

        val command = AddInventoryCommand(form.inventoryId, form.vehicleId)
        commandGateway.send<CompletableFuture<String>>(command)

        LOG.info("Sending command to add inventory: $command")
    }

    override fun rent(inventoryId: String) {
        LOG.info("Reservation inventory: $inventoryId")

        val command = ReserveInventoryCommand(inventoryId)
        commandGateway.sendAndWait<String>(command)

        LOG.info("Sending command to reserve inventory: $command")

        inventoryProcessor.carReservedAtLocation().send(MessageBuilder.withPayload(inventoryId).build())
    }
}