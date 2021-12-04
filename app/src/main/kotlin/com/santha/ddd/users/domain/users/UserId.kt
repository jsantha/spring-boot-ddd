package com.santha.ddd.users.domain.users

import com.santha.shared.domain.StronglyTypedId
import java.util.*

class UserId(id: UUID) : StronglyTypedId<UUID>(id)
