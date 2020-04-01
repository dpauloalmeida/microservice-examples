package com.example.rentalcar.reservation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/reservations")
class ReservationResource(
    private val reservationService: ReservationService
) {

    @PostMapping
    fun reserve(@RequestBody form: ReservationFormRequest,
                uriBuilder: UriComponentsBuilder): ResponseEntity<ReservationResponse> {

        val reserved = reservationService.create(form)
        val uri = uriBuilder.path("/reservations/{id}").buildAndExpand(reserved.id).toUri()
        return ResponseEntity.created(uri).body(reserved)
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long) = ResponseEntity.ok().body(reservationService.findById(id))
}