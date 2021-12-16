package io.github.artemptushkin.springbootkafkahelloworld.controller

import io.github.artemptushkin.springbootkafkahelloworld.service.TestProducerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(private val testProducerService: TestProducerService) {

    @PostMapping("/test:send")
    fun	send(@RequestBody message: String) {
        testProducerService.sendTestMessage(message)
    }
}