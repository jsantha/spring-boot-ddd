package com.santha.ddd.users.domain.users

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, UserId>, UsernameChecker {

}
