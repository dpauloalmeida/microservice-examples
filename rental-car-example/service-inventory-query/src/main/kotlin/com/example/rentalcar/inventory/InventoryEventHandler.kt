package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Inventory
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
@ProcessingGroup("inventories")
class InventoryEventHandler(
    private val inventoryRepository: InventoryRepository
) {

    @EventHandler
    fun on(event: InventoryAddedEvent) {
        val savedInventory = Inventory(event.inventoryId, event.vehicleId)
        inventoryRepository.save(savedInventory)
    }

    @EventHandler
    fun on(event: InventoryReservedEvent) {
        val foundInventory = inventoryRepository.findById(event.inventoryId)
            .orElseThrow { EntityNotFoundException("There is no inventory with id ${event.inventoryId}") }

        foundInventory.reserved = true
    }
}