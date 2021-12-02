package com.santha.shared.infrastructure.persistence.converters

import com.santha.shared.domain.StronglyTypedId
import javax.persistence.AttributeConverter

@Suppress("ConverterNotAnnotatedInspection")
abstract class StronglyTypedIdConverter<T, TId> : AttributeConverter<T, TId> where T : StronglyTypedId<TId> {
    override fun convertToDatabaseColumn(id: T?): TId? {
        return id?.value;
    }

    override fun convertToEntityAttribute(value: TId): T {
        return factory(value);
    }

    abstract fun factory(value: TId): T;
}
