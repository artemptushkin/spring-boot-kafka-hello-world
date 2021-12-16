package io.github.artemptushkin.springbootkafkahelloworld.controller

import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicIdPartition
import org.apache.kafka.common.TopicPartition
import org.springframework.web.bind.annotation.*
import java.time.Duration

@RestController
class TestController(private val kafkaConsumer: KafkaConsumer<String, String>) {

    @GetMapping("/messages")
    fun	send(@RequestParam offset: Long, @RequestParam partition: Int): List<String> {
        val topicPartition = TopicPartition("test-double-partition", partition)
        kafkaConsumer.assign(listOf(topicPartition))
        kafkaConsumer.seek(topicPartition, offset)

        return kafkaConsumer
                .poll(Duration.ofSeconds(5))
                .map { it.value() }
                .toList()
    }
}