package com.santha.ddd.users.application.registrations.createregistration

import an.awesome.pipelinr.Command
import an.awesome.pipelinr.Voidy
import com.santha.ddd.users.domain.registrations.UserRegistrationId

class CreateRegistrationCommand(val username: String) : Command<UserRegistrationId> {

}
