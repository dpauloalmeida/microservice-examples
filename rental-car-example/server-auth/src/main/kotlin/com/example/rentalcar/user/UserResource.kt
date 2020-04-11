package com.example.rentalcar.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/users")
class UserResource {

    @GetMapping
    fun getUserLoggedIn(user: Principal) = user

    @GetMapping("/{username}")
    fun detailByUsername(@PathVariable username: String): ResponseEntity<UserResponse> {
        val user = if(username == "danilo") UserResponse("1", "danilo", "ROLE_USER") else UserResponse("0", "other", "ROLE_USER")
        return ResponseEntity.ok(user)
    }

}