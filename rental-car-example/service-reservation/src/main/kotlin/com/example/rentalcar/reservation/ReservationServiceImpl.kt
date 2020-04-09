package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class ReservationServiceImpl(
    private val repository: ReservationRepository,
    private val reservationProcessor: ReservationProcessor
) : ReservationService {

    override fun create(form: ReservationFormRequest): Reservation {
        val savedReservation = form.toReservation()
        return repository.save(savedReservation).also {
            reservationProcessor.created().send(MessageBuilder.withPayload(it).build())
        }
    }

    override fun findById(id: Long): ReservationResponse {
        val foundReservation = repository.findById(id).orElseThrow { ResourceNotFoundException() }
        return foundReservation.toReservationResponse()
    }
}
