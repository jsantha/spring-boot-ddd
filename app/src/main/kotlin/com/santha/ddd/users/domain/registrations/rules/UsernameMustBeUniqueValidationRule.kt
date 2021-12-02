package com.santha.ddd.users.domain.registrations.rules

import com.santha.ddd.users.domain.users.UsernameChecker
import com.santha.shared.domain.BusinessRule

class UsernameMustBeUniqueValidationRule(private val checker: UsernameChecker, private val username: String) :
    BusinessRule {
    override val message: String
        get() = "Username already exists"

    override fun isBroken(): Boolean {
        return checker.existsByUsername(username)
    }
}
