package com.santha.ddd.users.application.registrations.createregistration

import an.awesome.pipelinr.Command
import an.awesome.pipelinr.Voidy

class CreateRegistrationCommand(val username: String) : Command<Voidy> {

}
