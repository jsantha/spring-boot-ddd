package com.santha.shared.infrastructure.pipeline

import an.awesome.pipelinr.Command
import org.hibernate.SessionFactory
import org.springframework.stereotype.Component

@Component
class TransactionMiddleware(private val sessionFactory: SessionFactory) : Command.Middleware {

    override operator fun <R, C : Command<R>?> invoke(command: C, next: Command.Middleware.Next<R>): R {
        val session = sessionFactory.openSession()

        try {
            session.transaction.begin()

            val result = next.invoke()

            session.transaction.commit()

            return result;
        } catch (e: Exception) {
            session.transaction.rollback()
            throw e
        }
    }
}
