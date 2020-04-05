package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Reservation
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class InventoryConsumer(
    private val inventoryCommandService: InventoryCommandService
) {

    @KafkaListener(topics = ["rental.reservationCreated"], groupId = "inventory_command_service_group")
    fun consume(data: Reservation) {
        inventoryCommandService.rent(data.inventoryId)
    }
}