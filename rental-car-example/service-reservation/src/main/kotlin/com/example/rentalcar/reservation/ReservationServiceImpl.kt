package com.example.rentalcar.reservation

import com.example.rentalcar.domain.Reservation
import org.slf4j.LoggerFactory
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class ReservationServiceImpl(
    private val repository: ReservationRepository,
    private val reservationProcessor: ReservationProcessor
) : ReservationService {

    companion object {
        private val LOG = LoggerFactory.getLogger(ReservationService::class.java)
    }

    override fun create(form: ReservationFormRequest): Reservation {
        LOG.info("Creating reservation: $form")

        val savedReservation = form.toReservation()
        return repository.save(savedReservation).also {
            reservationProcessor.created().send(MessageBuilder.withPayload(it).build())
            LOG.info("Reservation created: $it with status: ${it.status}")
        }
    }

    override fun findById(id: String): ReservationResponse {
        val foundReservation = repository.findById(id).orElseThrow { ResourceNotFoundException() }
        return foundReservation.toReservationResponse()
    }
}
