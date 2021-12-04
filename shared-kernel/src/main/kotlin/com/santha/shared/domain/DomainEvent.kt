package com.santha.shared.domain

import java.time.LocalDateTime
import java.util.*

interface DomainEvent {
    val id: UUID
    val occurredOn: LocalDateTime
}
