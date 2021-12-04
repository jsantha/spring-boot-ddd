package com.santha.shared.domain

import org.springframework.data.domain.AfterDomainEventPublication
import org.springframework.data.domain.DomainEvents

abstract class DomainEntity<TId> protected constructor() where TId : StronglyTypedId<*> {

    private val domainEvents = ArrayList<DomainEvent>()

    @DomainEvents
    fun domainEvents(): List<DomainEvent> = domainEvents

    @AfterDomainEventPublication
    fun clearDomainEvents() {
        domainEvents.clear()
    }

    protected fun addDomainEvent(event: DomainEvent) {
        domainEvents.add(event)
    }

    protected fun checkRule(rule: BusinessRule) {
        if (rule.isBroken()) {
            throw BusinessRuleValidationException(rule);
        }
    }
}
