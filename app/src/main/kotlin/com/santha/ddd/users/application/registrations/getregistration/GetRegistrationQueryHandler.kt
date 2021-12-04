package com.santha.ddd.users.application.registrations.getregistration

import an.awesome.pipelinr.Command
import com.santha.ddd.users.domain.registrations.UserRegistration
import com.santha.ddd.users.domain.registrations.UserRegistrationRepository
import org.springframework.stereotype.Component

@Component
class GetRegistrationQueryHandler(private val registrationRepository: UserRegistrationRepository) : Command.Handler<GetRegistrationQuery, UserRegistration> {

    override fun handle(query: GetRegistrationQuery): UserRegistration {
        return registrationRepository.getById(query.id)
    }
}
