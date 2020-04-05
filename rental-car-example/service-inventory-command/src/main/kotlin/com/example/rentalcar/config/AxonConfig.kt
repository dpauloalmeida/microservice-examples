package com.example.rentalcar.config

import org.axonframework.extensions.kafka.KafkaProperties
import org.axonframework.extensions.kafka.eventhandling.producer.ConfirmationMode
import org.axonframework.extensions.kafka.eventhandling.producer.DefaultProducerFactory
import org.axonframework.extensions.kafka.eventhandling.producer.ProducerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {

    @Bean
    fun producerFactory(kafkaProperties: KafkaProperties): ProducerFactory<String, ByteArray> {
        return DefaultProducerFactory.builder<String, ByteArray>()
            .configuration(kafkaProperties.buildProducerProperties())
            .confirmationMode(ConfirmationMode.WAIT_FOR_ACK)
            .build()
    }
}