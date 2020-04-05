package com.example.rentalcar.reservation

import org.springframework.stereotype.Service

@Service
class ReservationServiceImpl(
    private val repository: ReservationRepository,
    private val reservationProducer: ReservationProducer
) : ReservationService {

    override fun create(form: ReservationFormRequest): ReservationResponse {
        val savedReservation = form.toReservation()

        repository.save(savedReservation)
        reservationProducer.produce(savedReservation)

        return savedReservation.toReservationResponse()
    }

    override fun findById(id: Long): ReservationResponse {
        val foundReservation = repository.findById(id).orElseThrow { ResourceNotFoundException() }
        return foundReservation.toReservationResponse()
    }
}
