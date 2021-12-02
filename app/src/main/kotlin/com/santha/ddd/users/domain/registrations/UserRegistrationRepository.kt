package com.santha.ddd.users.domain.registrations

import org.springframework.data.jpa.repository.JpaRepository

interface UserRegistrationRepository : JpaRepository<UserRegistration, UserRegistrationId> {
}
