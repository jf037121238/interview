package com.hammerhead.io.service.controller

import com.hammerhead.io.service.service.UserRouteService
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Lazy
@RestController
class UserRouteController(val userRouteService: UserRouteService) {

    @GetMapping("/user/{userId}/route")
    fun get(@PathVariable userId: Int
            , @RequestParam(required = false) service: String?): ResponseEntity<List<String>> {
        return ResponseEntity(userRouteService.get(userId, service), HttpStatus.OK)
    }
}