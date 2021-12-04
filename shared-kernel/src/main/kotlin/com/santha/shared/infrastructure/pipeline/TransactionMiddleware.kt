package com.santha.shared.infrastructure.pipeline

import an.awesome.pipelinr.Command
import com.santha.shared.application.configuration.Query
import org.hibernate.SessionFactory
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2000)
class TransactionMiddleware(private val sessionFactory: SessionFactory) : Command.Middleware {

    private val logger = LoggerFactory.getLogger(TransactionMiddleware::class.java)

    override operator fun <R, C : Command<R>?> invoke(command: C, next: Command.Middleware.Next<R>): R {
        if (command is Query<*>) {
            return next.invoke()
        }

        return invokeInTransaction(next)
    }

    private fun <R> invokeInTransaction(next: Command.Middleware.Next<R>): R {
        val session = sessionFactory.openSession()
        logger.trace("Transaction begin")
        val transaction = session.beginTransaction()

        try {
            val result = next.invoke()

            logger.trace("Transaction commit")
            transaction.commit()

            return result
        } catch (e: Exception) {
            logger.trace("Transaction rollback")
            transaction.rollback()
            throw e
        } finally {
            session.close()
        }
    }
}
