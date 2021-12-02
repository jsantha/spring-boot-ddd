package com.santha.ddd.users.domain.registrations

import com.santha.ddd.users.domain.registrations.rules.UsernameMustBeUniqueValidationRule
import com.santha.ddd.users.domain.users.UsernameChecker
import com.santha.ddd.users.infrastructure.persistence.converters.UserRegistrationIdType
import com.santha.shared.domain.DomainEntity
import org.hibernate.annotations.TypeDef
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@TypeDef(defaultForType = UserRegistrationId::class, typeClass = UserRegistrationIdType::class)
@Entity
class UserRegistration : DomainEntity<UserRegistrationId> {

    @Id
    @Column(columnDefinition = "UUID")
    lateinit var id: UserRegistrationId
    private set

    @Column(nullable = false)
    lateinit var username: String
    private set

    protected constructor()

    private constructor(checker: UsernameChecker, username: String) {
        checkRule(UsernameMustBeUniqueValidationRule(checker, username))

        this.id = UserRegistrationId(UUID.randomUUID());
        this.username = username;
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
