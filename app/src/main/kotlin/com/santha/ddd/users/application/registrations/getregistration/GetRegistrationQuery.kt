package com.santha.ddd.users.application.registrations.getregistration

import com.santha.ddd.users.domain.registrations.UserRegistration
import com.santha.ddd.users.domain.registrations.UserRegistrationId
import com.santha.shared.application.configuration.Query

class GetRegistrationQuery(val id: UserRegistrationId) : Query<UserRegistration> {
}
