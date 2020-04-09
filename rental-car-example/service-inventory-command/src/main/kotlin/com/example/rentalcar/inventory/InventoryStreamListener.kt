package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Reservation
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Component

@Component
class InventoryStreamListener(
    private val inventoryCommandService: InventoryCommandService
) {

    @StreamListener(InventoryProcessor.CREATED_IN)
    fun listen(event: Reservation) {
        inventoryCommandService.rent(event.inventoryId)
    }
}