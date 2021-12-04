package com.santha.ddd.users.domain.registrations

import com.santha.ddd.users.domain.registrations.events.NewUserRegisteredDomainEvent
import com.santha.ddd.users.domain.registrations.rules.UsernameMustBeUniqueValidationRule
import com.santha.ddd.users.domain.users.UsernameChecker
import com.santha.shared.domain.DomainEntity
import java.util.*

class UserRegistration : DomainEntity<UserRegistrationId> {

    lateinit var id: UserRegistrationId
    private set

    private lateinit var username: String

    protected constructor()

    private constructor(checker: UsernameChecker, username: String) {
        checkRule(UsernameMustBeUniqueValidationRule(checker, username))

        this.id = UserRegistrationId(UUID.randomUUID());
        this.username = username;

        addDomainEvent(NewUserRegisteredDomainEvent(id, username))
    }

    fun confirm() {
        val id = UserRegistrationId(UUID.randomUUID());
        var userId = UserRegistrationId(UUID.randomUUID());
    }

    companion object {
        fun create(checker: UsernameChecker, username: String): UserRegistration {
            return UserRegistration(checker, username);
        }
    }
}
