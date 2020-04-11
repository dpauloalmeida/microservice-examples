package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Inventory
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
@ProcessingGroup("inventories")
class InventoryEventHandler(
    private val inventoryRepository: InventoryRepository
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(InventoryEventHandler::class.java)
    }

    @EventHandler
    fun on(event: InventoryAddedEvent) {
        LOG.info("Processing event to add inventory: $event")

        val savedInventory = Inventory(event.inventoryId, event.vehicleId)
        inventoryRepository.save(savedInventory).also {
            LOG.info("Inventory added: $it")
        }
    }

    @EventHandler
    fun on(event: InventoryReservedEvent) {
        LOG.info("Processing event to reserve inventory: $event")

        val foundInventory = inventoryRepository.findById(event.inventoryId)
            .orElseThrow { EntityNotFoundException("There is no inventory with id ${event.inventoryId}") }

        foundInventory.reserved = true

        LOG.info("Inventory reserved: $foundInventory")
    }
}