package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.type.descriptor.WrapperOptions
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor

class StronglyTypedIdTypeDescriptor<T>(type: Class<T>, private val factory: (Any) -> T) : AbstractTypeDescriptor<T>(type) where T : StronglyTypedId<*> {

    override fun fromString(value: String?): T? {
        return if (value == null) null else factory(value);
    }

    override fun <X : Any?> unwrap(value: T?, type: Class<X>, options: WrapperOptions?): X? {
        if (value == null) {
            return null
        }

        if (type.isAssignableFrom(javaType)) {
            return type.cast(value)
        }

        if (type.isAssignableFrom(String::class.java)) {
            return type.cast(value.value.toString())
        }

        throw unknownUnwrap(type)
    }

    override fun <X : Any?> wrap(value: X?, options: WrapperOptions?): T? {
        if (value == null) {
            return null
        }

        if (javaType.isInstance(value)) {
            return javaType.cast(value)
        }

        if (value is String) {
            return fromString(value)
        }

        throw unknownWrap(value!!::class.java)
    }
}
