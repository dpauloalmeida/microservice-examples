package com.example.rentalcar.config

import org.axonframework.config.EventProcessingConfigurer
import org.axonframework.eventhandling.tokenstore.inmemory.InMemoryTokenStore
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.axonframework.extensions.kafka.eventhandling.consumer.streamable.StreamableKafkaMessageSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty(value = ["axon.kafka.consumer.event-processor-mode"], havingValue = "TRACKING")
class AxonConfig {

    @Bean
    fun eventStore() = EmbeddedEventStore.builder().storageEngine(InMemoryEventStorageEngine()).build()

    @Bean
    fun tokenStore() = InMemoryTokenStore()

    @Autowired
    fun configureStreamableKafkaSource(processingConfigurer: EventProcessingConfigurer,
                                       kafkaMessageSource: StreamableKafkaMessageSource<String, ByteArray>) {

        processingConfigurer.registerTrackingEventProcessor("inventories") { kafkaMessageSource }
    }
}