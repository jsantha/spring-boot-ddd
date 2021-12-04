package com.santha.shared.domain

import java.time.LocalDateTime
import java.util.*

abstract class DomainEventBase : DomainEvent {
    override val id: UUID = UUID.randomUUID()
    override val occurredOn: LocalDateTime = LocalDateTime.now()
}
