@TypeDefs({
    @TypeDef(defaultForType = UserRegistrationId.class, typeClass = UserRegistrationIdType.class),
    @TypeDef(defaultForType = UserId.class, typeClass = UserIdType.class)
})
package com.santha.ddd.users.domain;

import com.santha.ddd.users.domain.registrations.UserRegistrationId;
import com.santha.ddd.users.domain.users.UserId;
import com.santha.ddd.users.infrastructure.persistence.types.UserIdType;
import com.santha.ddd.users.infrastructure.persistence.types.UserRegistrationIdType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
