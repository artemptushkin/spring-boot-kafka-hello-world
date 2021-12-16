package io.github.artemptushkin.springbootkafkahelloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumerKafkaApplication

fun main(args: Array<String>) {
    runApplication<ConsumerKafkaApplication>(*args)
}
