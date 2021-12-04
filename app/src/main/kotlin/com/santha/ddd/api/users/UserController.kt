package com.santha.ddd.api.users

import an.awesome.pipelinr.Pipeline
import com.santha.ddd.users.application.registrations.createregistration.CreateRegistrationCommand
import com.santha.ddd.users.application.registrations.getregistration.GetRegistrationQuery
import com.santha.ddd.users.domain.registrations.UserRegistration
import com.santha.ddd.users.domain.registrations.UserRegistrationId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(private val pipeline: Pipeline) {

    @GetMapping
    fun createUserRegistration(): UserRegistration {
        val id = pipeline.send(CreateRegistrationCommand("lala"));

        return pipeline.send(GetRegistrationQuery(id))
    }

    @GetMapping("{id}")
    fun getUserRegistration(@PathVariable id: UUID): UserRegistration {
        return pipeline.send(GetRegistrationQuery(UserRegistrationId(id)))
    }
}
