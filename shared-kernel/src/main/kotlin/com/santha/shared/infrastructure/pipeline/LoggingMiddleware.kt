package com.santha.shared.infrastructure.pipeline

import an.awesome.pipelinr.Command
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LoggingMiddleware : Command.Middleware {
    private val logger = LoggerFactory.getLogger(LoggingMiddleware::class.java);

    override operator fun <R, C : Command<R>?> invoke(command: C, next: Command.Middleware.Next<R>): R {
        val typeName = command!!::class.qualifiedName;

        try {
            logger.debug("Executing command {}", typeName)

            val result = next.invoke()

            logger.debug("Command processed {} correctly", typeName)

            return result;
        } catch (e: Exception) {
            logger.debug("Command {} processing failed", typeName)
            throw e;
        }
    }
}
