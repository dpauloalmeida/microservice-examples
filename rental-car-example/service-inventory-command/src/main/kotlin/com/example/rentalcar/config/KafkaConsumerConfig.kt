package com.example.rentalcar.config

import com.example.rentalcar.domain.Reservation
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import kotlin.reflect.jvm.jvmName

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Reservation> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Reservation>()

        factory.consumerFactory = DefaultKafkaConsumerFactory(consumeFactory(),
            StringDeserializer(), JsonDeserializer(Reservation::class.java))

        return factory
    }

    fun consumeFactory(): Map<String, String> {
        return mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9091",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.jvmName,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.jvmName,
            ConsumerConfig.GROUP_ID_CONFIG to "inventory_command_service_group",
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest"
        )
    }
}