package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.id.ResultSetIdentifierConsumer
import org.hibernate.type.AbstractSingleColumnStandardBasicType
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor
import java.io.Serializable
import java.lang.Exception
import java.sql.ResultSet

abstract class StronglyTypedIdType<T>(descriptor: StronglyTypedIdTypeDescriptor<T>) :
    AbstractSingleColumnStandardBasicType<T>(VarcharTypeDescriptor.INSTANCE, descriptor),
    ResultSetIdentifierConsumer where T : StronglyTypedId<*> {

    override fun getName(): String = javaTypeDescriptor.javaType.simpleName

    override fun consumeIdentifier(resultSet: ResultSet?): Serializable {
        throw Exception("Implement")
    }
}
