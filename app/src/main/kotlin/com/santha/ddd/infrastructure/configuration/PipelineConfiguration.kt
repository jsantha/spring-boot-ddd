package com.santha.ddd.infrastructure.configuration

import an.awesome.pipelinr.*
import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PipelineConfiguration {

    @Bean
    fun pipeline(
        commandHandlers: ObjectProvider<Command.Handler<*, *>>,
        notificationHandlers: ObjectProvider<Notification.Handler<*>>,
        middlewares: ObjectProvider<Command.Middleware>
    ): Pipeline {
        return Pipelinr()
            .with(commandHandlers::stream)
            .with(notificationHandlers::stream)
            .with(middlewares::orderedStream)
    }
}
