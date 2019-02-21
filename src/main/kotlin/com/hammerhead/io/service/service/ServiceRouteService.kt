package com.hammerhead.io.service.service

import com.hammerhead.io.service.repository.ServiceRouteRepository
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class ServiceRouteService(val serviceRouteRepository: ServiceRouteRepository) {

    /**
     * Returns a list all routes amongst all services.
     */
    fun get(): List<String> {
        return serviceRouteRepository.findAll().map { it.route.route }
    }
}