package com.example.rentalcar.inventory

import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames = ["inventories"])
class InventoryQueryServiceImpl(
    private val queryGateway: QueryGateway
) : InventoryQueryService {

    @Cacheable
    override fun findAll(): List<InventoryResponse> {
       return queryGateway.query(FindAllInventoryQuery(),
           ResponseTypes.multipleInstancesOf(InventoryResponse::class.java)).join()
    }

    override fun findById(id: String): InventoryResponse {
        return queryGateway.query(FindByIdInventoryQuery(id), InventoryResponse::class.java).join()
            ?: throw ResourceNotFoundException()
    }
}