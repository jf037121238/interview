package com.hammerhead.io.service.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping(value = ["/"])
    fun get() : ResponseEntity<String> {
        return ResponseEntity("Hello World!", HttpStatus.I_AM_A_TEAPOT)
    }
}