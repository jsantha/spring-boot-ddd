package com.santha.ddd.users.infrastructure.persistence.types

import com.santha.ddd.users.domain.registrations.UserRegistrationId
import com.santha.shared.infrastructure.persistence.types.UUIDStronglyTypedIdType

class UserRegistrationIdType : UUIDStronglyTypedIdType<UserRegistrationId>(UserRegistrationId::class.java)
