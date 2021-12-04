package com.santha.ddd.users.infrastructure.persistence.types

import com.santha.ddd.users.domain.users.UserId
import com.santha.shared.infrastructure.persistence.types.UUIDStronglyTypedIdType

class UserIdType : UUIDStronglyTypedIdType<UserId>(UserId::class.java)
