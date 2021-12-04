package com.santha.ddd.users.domain.registrations.events

import com.santha.ddd.users.domain.registrations.UserRegistrationId
import com.santha.shared.domain.DomainEventBase

class NewUserRegisteredDomainEvent(
    val userRegistrationId: UserRegistrationId,
    val username: String
) : DomainEventBase()
