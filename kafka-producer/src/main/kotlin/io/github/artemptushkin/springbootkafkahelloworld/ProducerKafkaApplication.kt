package io.github.artemptushkin.springbootkafkahelloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProducerKafkaApplication

fun main(args: Array<String>) {
    runApplication<ProducerKafkaApplication>(*args)
}
