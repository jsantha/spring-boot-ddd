package com.santha.shared.infrastructure.persistence.types

import com.santha.shared.domain.StronglyTypedId
import org.hibernate.type.AbstractSingleColumnStandardBasicType
import org.hibernate.type.descriptor.java.JavaTypeDescriptor
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor

abstract class StronglyTypedIdType<T>(sqlTypeDescriptor: SqlTypeDescriptor, javaTypeDescriptor: JavaTypeDescriptor<T>) :
    AbstractSingleColumnStandardBasicType<T>(sqlTypeDescriptor, javaTypeDescriptor) where T : StronglyTypedId<*> {

    override fun getName(): String = javaTypeDescriptor.javaType.simpleName
}
