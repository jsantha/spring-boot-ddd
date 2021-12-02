package com.santha.ddd.users.domain.users

import com.santha.ddd.users.infrastructure.persistence.converters.UserIdType
import org.hibernate.annotations.TypeDef
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@TypeDef(defaultForType = UserId::class, typeClass = UserIdType::class)
@Entity
class User {

    @Id
    private lateinit var id: UserId;

    @Column
    private lateinit var username: String;
}
