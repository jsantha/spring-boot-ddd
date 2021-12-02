package com.santha.ddd.api.users

import an.awesome.pipelinr.Pipeline
import com.santha.ddd.users.application.registrations.createregistration.CreateRegistrationCommand
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val pipeline: Pipeline) {

    @GetMapping
    fun createUserRegistration() {
        pipeline.send(CreateRegistrationCommand("lala"));
    }
}
