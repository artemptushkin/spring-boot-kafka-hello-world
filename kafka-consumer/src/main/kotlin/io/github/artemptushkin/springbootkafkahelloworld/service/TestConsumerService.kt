package io.github.artemptushkin.springbootkafkahelloworld.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.PartitionOffset
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.stereotype.Service

@Service
class TestConsumerService {

    @KafkaListener(topics = ["test"], groupId = "foo")
    fun listenHelloTopic1(message: String) {
        println("[1] Received by the consumer group 1 $message")
    }

    @KafkaListener(topics = ["test"], groupId = "baz")
    fun listenHelloTopic2(message: String) {
        println("[2] Received by the consumer group 2 $message")
    }

    @KafkaListener(topicPartitions = [
        TopicPartition(topic = "test-double-partition", partitionOffsets = [
            PartitionOffset(partition = "0", initialOffset = "0")
        ])
    ], groupId = "partitioned-group")
    fun listenFromBeginning(message: String) {
        println("[0] Receiving messages from the beginning: $message")
    }

    @KafkaListener(topicPartitions = [
        TopicPartition(topic = "test-double-partition", partitionOffsets = [
            PartitionOffset(partition = "1", initialOffset = "0")
        ])
    ], groupId = "partitioned-group")
    fun listenFromBeginningSecondPartion(message: String) {
        println("[1] Receiving messages from the beginning: $message")
    }

    @KafkaListener(topicPartitions = [
        TopicPartition(topic = "test-double-partition", partitionOffsets = [
            PartitionOffset(partition = "1", initialOffset = "0")
        ])
    ], groupId = "partitioned-group")
    fun listenFromBeginningWhenThereAreMoreConsumersThanPartitions(message: String) {
        println("[2] I shouldn't receive this message: $message")
    }
}