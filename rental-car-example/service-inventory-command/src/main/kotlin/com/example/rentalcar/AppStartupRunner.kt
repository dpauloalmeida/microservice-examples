package com.example.rentalcar

import com.example.rentalcar.inventory.InventoryCommandService
import com.example.rentalcar.inventory.InventoryFormRequest
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppStartupRunner(
    private val inventoryCommandService: InventoryCommandService
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        repeat(10) { inventoryCommandService.create(InventoryFormRequest(vehicleId = it.toString())) }
    }
}