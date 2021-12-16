package io.github.artemptushkin.springbootkafkahelloworld.controller

import io.github.artemptushkin.springbootkafkahelloworld.service.TestProducerService
import org.springframework.web.bind.annotation.*

@RestController
class TestController(private val testProducerService: TestProducerService) {

    @PostMapping("/{topicName}:send")
    fun	send(@RequestBody message: String, @PathVariable topicName: String) {
        testProducerService.sendTestMessage(message, topicName)
    }
}