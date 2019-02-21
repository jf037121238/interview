package com.hammerhead.io.service.service

import com.hammerhead.io.service.repository.RouteRepository
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class RouteService(val routeRepository: RouteRepository) {

    /**
     * Returns a unique list of routes
     */
    fun get() : List<String> {
        return routeRepository.findAll().map{ it.route }
    }
}