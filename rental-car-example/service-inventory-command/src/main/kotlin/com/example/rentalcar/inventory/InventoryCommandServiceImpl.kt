package com.example.rentalcar.inventory

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class InventoryCommandServiceImpl(
    private val commandGateway: CommandGateway
) : InventoryCommandService {

    override fun create(form: InventoryFormRequest) {
        val command = AddInventoryCommand(form.inventoryId, form.vehicleId)
        commandGateway.send<CompletableFuture<String>>(command)
    }

    override fun rent(inventoryId: String) {
        val command = ReserveInventoryCommand(inventoryId)
        commandGateway.send<CompletableFuture<String>>(command)
    }
}