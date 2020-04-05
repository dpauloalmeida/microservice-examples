package com.example.rentalcar.inventory

interface InventoryQueryService {
    fun findAll(): List<InventoryResponse>
    fun findById(id: String): InventoryResponse
}
