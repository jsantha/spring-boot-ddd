package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.type.PostgresUUIDType
import java.util.*

abstract class UUIDStronglyTypedIdType<T>(type: Class<T>) :
    StronglyTypedIdType<T>(
        PostgresUUIDType.PostgresUUIDSqlTypeDescriptor.INSTANCE,
        UUIDStronglyTypedIdTypeDescriptor(type)
    ) where T : StronglyTypedId<UUID>
