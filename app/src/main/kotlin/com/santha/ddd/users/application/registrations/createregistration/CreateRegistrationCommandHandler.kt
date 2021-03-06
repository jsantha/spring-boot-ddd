package com.santha.ddd.users.application.registrations.createregistration

import an.awesome.pipelinr.Command
import an.awesome.pipelinr.Voidy
import com.santha.ddd.users.domain.registrations.UserRegistration
import com.santha.ddd.users.domain.registrations.UserRegistrationId
import com.santha.ddd.users.domain.registrations.UserRegistrationRepository
import com.santha.ddd.users.domain.users.UserRepository
import org.springframework.stereotype.Component

@Component
class CreateRegistrationCommandHandler(
    private val userRepository: UserRepository,
    private val userRegistrationRepository: UserRegistrationRepository
) : Command.Handler<CreateRegistrationCommand, UserRegistrationId> {

    override fun handle(request: CreateRegistrationCommand): UserRegistrationId {
        val registration = UserRegistration.create(userRepository, request.username);

        userRegistrationRepository.save(registration)

        return registration.id
    }
}
