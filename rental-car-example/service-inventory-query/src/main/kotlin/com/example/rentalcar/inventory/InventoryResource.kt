package com.example.rentalcar.inventory

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/inventories")
class InventoryResource(
    private val inventoryQueryService: InventoryQueryService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<InventoryResponse>> {
        val inventories = inventoryQueryService.findAll()
        return ResponseEntity.ok(inventories)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<InventoryResponse> {
        val inventory = inventoryQueryService.findById(id)
        return ResponseEntity.ok(inventory)
    }
}