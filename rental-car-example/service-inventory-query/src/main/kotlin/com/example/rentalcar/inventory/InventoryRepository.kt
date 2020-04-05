package com.example.rentalcar.inventory

import com.example.rentalcar.domain.Inventory
import org.springframework.data.jpa.repository.JpaRepository

interface InventoryRepository : JpaRepository<Inventory, String> {
}