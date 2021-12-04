package com.santha.shared.domain

import java.io.Serializable
import java.util.*

abstract class StronglyTypedId<T>(val value: T) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other == null || this.javaClass != other.javaClass) {
            return false
        }

        val that = other as StronglyTypedId<*>

        return that.value == this.value
    }

    override fun hashCode(): Int = Objects.hash(value)
}
