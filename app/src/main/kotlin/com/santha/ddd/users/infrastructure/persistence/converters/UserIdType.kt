package com.santha.ddd.users.infrastructure.persistence.converters

import com.santha.ddd.users.domain.users.UserId
import com.santha.shared.infrastructure.persistence.types.StronglyTypedIdType
import com.santha.shared.infrastructure.persistence.types.StronglyTypedIdTypeDescriptor
import java.util.*

class UserIdType : StronglyTypedIdType<UserId>(StronglyTypedIdTypeDescriptor(UserId::class.java, ::factory)) {
    companion object {
        fun factory(id: Any): UserId = UserId(id as UUID)
    }
}

