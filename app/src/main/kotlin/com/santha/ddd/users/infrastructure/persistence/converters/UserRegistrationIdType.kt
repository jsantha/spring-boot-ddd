package com.santha.ddd.users.infrastructure.persistence.converters

import com.santha.ddd.users.domain.registrations.UserRegistrationId
import com.santha.shared.infrastructure.persistence.types.StronglyTypedIdType
import com.santha.shared.infrastructure.persistence.types.StronglyTypedIdTypeDescriptor
import java.util.*

class UserRegistrationIdType : StronglyTypedIdType<UserRegistrationId>(StronglyTypedIdTypeDescriptor(UserRegistrationId::class.java, ::factory)) {
    companion object {
        fun factory(id: Any): UserRegistrationId = UserRegistrationId(id as UUID)
    }
}

