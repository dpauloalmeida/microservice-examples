package com.example.rentalcar.inventory

import org.axonframework.queryhandling.QueryHandler
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class InventoryQueryHandler(
    private val inventoryRepository: InventoryRepository
) {

    @QueryHandler
    fun handle(query: FindAllInventoryQuery) =
        inventoryRepository.findAll()
            .filter { !it.reserved }
            .map { it.toInventoryResponse() }

    @QueryHandler
    fun handle(query: FindByIdInventoryQuery) =
        inventoryRepository.findByIdOrNull(query.id)
            ?.toInventoryResponse()

}