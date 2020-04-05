package com.example.rentalcar.inventory

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/inventories")
class InventoryResource(
    private val inventoryCommandService: InventoryCommandService
) {

    @PostMapping
    fun add(@RequestBody form: InventoryFormRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Unit> {
        inventoryCommandService.create(form)
        val uri = uriBuilder.path("/inventories/{id}").buildAndExpand(form.inventoryId).toUri()
        return ResponseEntity.created(uri).build()
    }
}