package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor

abstract class StronglyTypedIdTypeDescriptor<T>(private val type: Class<T>) :
    AbstractTypeDescriptor<T>(type) where T : StronglyTypedId<*> {

    @Suppress("UNCHECKED_CAST")
    protected fun factory(value: Any?): T? {
        if (value == null) {
            return null
        }

        return type.constructors[0].newInstance(value) as T
    }
}
