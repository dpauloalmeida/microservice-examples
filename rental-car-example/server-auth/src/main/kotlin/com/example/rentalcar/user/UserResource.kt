package com.example.rentalcar.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/users")
class UserResource {

    @GetMapping
    fun getUserLoggedIn(user: Principal) = user

}