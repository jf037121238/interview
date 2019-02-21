package com.hammerhead.io.service.controller

import com.hammerhead.io.service.service.RouteService
import org.springframework.context.annotation.Lazy
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Lazy
class RouteController (val routeService: RouteService) {

    @GetMapping(value = "/route")
    fun get() : ResponseEntity<List<String>> {
        return ResponseEntity(routeService.get(), HttpStatus.OK)
    }


}