package com.santha.ddd.users.domain.users

interface UsernameChecker {
    fun existsByUsername(username: String): Boolean
}
