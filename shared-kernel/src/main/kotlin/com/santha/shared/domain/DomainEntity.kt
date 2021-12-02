package com.santha.shared.domain

abstract class DomainEntity<TId> protected constructor() where TId : StronglyTypedId<*> {

    protected fun checkRule(rule: BusinessRule) {
        if (rule.isBroken()) {
            throw BusinessRuleValidationException(rule);
        }
    }
}
