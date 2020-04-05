package com.example.rentalcar.inventory


interface InventoryCommandService {
    fun create(form: InventoryFormRequest)
    fun rent(inventoryId: String)
}
