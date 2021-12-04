package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.type.descriptor.WrapperOptions
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor
import java.util.*

class UUIDStronglyTypedIdTypeDescriptor<T>(type: Class<T>) :
    StronglyTypedIdTypeDescriptor<T>(type) where T : StronglyTypedId<UUID> {

    override fun fromString(string: String?): T? {
        return factory(UUIDTypeDescriptor.INSTANCE.fromString(string))
    }

    override fun <X : Any?> unwrap(value: T?, type: Class<X>?, options: WrapperOptions?): X {
        return UUIDTypeDescriptor.INSTANCE.unwrap(value?.value, type, options)
    }

    override fun <X : Any?> wrap(value: X, options: WrapperOptions?): T? {
        return factory(UUIDTypeDescriptor.INSTANCE.wrap(value, options))
    }
}
