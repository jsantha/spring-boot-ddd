package com.santha.ddd.users.application.registrations.newuserregisteredeventhandler

import com.santha.ddd.users.domain.registrations.events.NewUserRegisteredDomainEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class NewUserRegisteredDomainEventHandler {

    @EventListener
    fun handle(event: NewUserRegisteredDomainEvent) {
        val a = 1
    }
}
