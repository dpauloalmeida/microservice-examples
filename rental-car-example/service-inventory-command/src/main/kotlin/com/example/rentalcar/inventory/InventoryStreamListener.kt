package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Reservation
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component

@Component
class InventoryStreamListener(
    private val inventoryCommandService: InventoryCommandService
) {

    companion object {
        private val LOG = LoggerFactory.getLogger(InventoryStreamListener::class.java)
    }

    @StreamListener(InventoryProcessor.CREATED_IN)
    fun listen(event: Reservation) {
        LOG.info("Processing event: $event - ${InventoryProcessor.CREATED_IN}")

        inventoryCommandService.rent(event.inventoryId)
    }
}