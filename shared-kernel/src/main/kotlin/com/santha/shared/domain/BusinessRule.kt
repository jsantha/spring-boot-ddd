package com.santha.shared.domain

interface BusinessRule {
    val message: String
    fun isBroken(): Boolean
}
