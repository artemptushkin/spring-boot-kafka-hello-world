package io.github.artemptushkin.springbootkafkahelloworld.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class TestProducerService(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendTestMessage(message: String) {
        kafkaTemplate.send(MessageBuilder.createMessage(message, MessageHeaders(
                mapOf(
                        "kafka_topic" to "test",
                        "test-header" to "test-header-value"
                )
        )))
    }
}