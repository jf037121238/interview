package com.hammerhead.io.service.repository

import com.hammerhead.io.service.dao.RouteDAO
import org.springframework.data.repository.CrudRepository

interface RouteRepository : CrudRepository<RouteDAO, Int>