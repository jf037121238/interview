package com.hammerhead.io.service.repository

import com.hammerhead.io.service.dao.ServiceRouteDAO
import org.springframework.data.repository.CrudRepository

interface ServiceRouteRepository : CrudRepository<ServiceRouteDAO, Int>